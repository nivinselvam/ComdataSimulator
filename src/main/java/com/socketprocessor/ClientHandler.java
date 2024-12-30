/*
This class is used for handling the client requests/responses.
Each client gets handled in a separate thread.
 */
package com.socketprocessor;

import com.base.Main;
import com.transactionProcessor.ResponseGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler extends Thread {
    private static final Logger logger = LogManager.getLogger(ClientHandler.class);
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private byte[] byteArray;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "Client " + socket.getRemoteSocketAddress().toString() + " is connected.");
        try {
            logger.log(Level.INFO, "---------------------------------------------------------------------");
            logger.log(Level.INFO, "                       Start of Transaction                          ");
            logger.log(Level.INFO, "---------------------------------------------------------------------");
            String transactionRequestPacket = readDataFromSocket();
            ResponseGenerator responseGenerator = new ResponseGenerator(transactionRequestPacket);
            responseGenerator.generateResponse();
            writeToSocket(Main.variables.responsePacket);
            logger.log(Level.INFO, transactionRequestPacket);
            logger.log(Level.INFO, "---------------------------------------------------------------------");
            logger.log(Level.INFO, "                         End of Transaction                          ");
            logger.log(Level.INFO, "---------------------------------------------------------------------");
        } catch (IOException e) {
            logger.log(Level.ERROR, e.toString());
        }
    }

    /***
     * This method is used for reading the data from the socket.
     * Program waits for the data to be available in the socket and reads it as soon as available.
     * First the length of the total bytes available is read and then followed by the actual data.
     * @return requestPacket
     * @throws IOException
     */
    private String readDataFromSocket() throws IOException {
        dataInputStream = new DataInputStream(socket.getInputStream());
        //For monitoring the socket continuously and read data whenever available.
        while (true) {
            logger.log(Level.INFO, "Waiting for client data...");
            while (dataInputStream.available() == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    logger.log(Level.ERROR, e.toString());
                }
            }

            logger.log(Level.DEBUG, "Trying to read data from the socket.");
            int socketDataLength = dataInputStream.available();
            byteArray = new byte[socketDataLength];
            dataInputStream.read(byteArray);
            String requestPacket = new String(byteArray, StandardCharsets.UTF_8);
            logger.log(Level.DEBUG, "Request received: " + requestPacket);
            return requestPacket;
        }
    }

    /**
     * This method is used for closing the socket along with the input and output streams.
     *
     * @param stringDataToBeSent
     */
    private void writeToSocket(String stringDataToBeSent) {
        logger.log(Level.DEBUG, "Data to be written into the socket: \n" + stringDataToBeSent);
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            logger.log(Level.DEBUG, "Trying to write data into the socket");
            byteArray = Main.converter.convertStringToBytes(stringDataToBeSent);
            if (byteArray != null) {
                dataOutputStream.write(byteArray);
                dataOutputStream.flush();
            }

        } catch (IOException e) {
            logger.log(Level.ERROR, "Error during conversion from string to bytes\n" + e.toString());
        }
    }

    /***
     * This method is used for closing the socket along with the input and output streams.
     * @throws IOException
     */
    private void closeSocket() throws IOException {
        logger.debug("Trying to close the client socket...");
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        logger.debug("Client socket closed successfully.");
    }
}
