package com.socketprocessor;

import com.base.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerInitializer extends Thread {
    private static final Logger logger = LogManager.getLogger(ServerInitializer.class);
    private ServerSocket serverSocket;
    public ClientHandler clientHandler;


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(Main.simulatorProperties.getPortNumber());
            logger.log(Level.INFO, "Server started on the port number "+ Main.simulatorProperties.getPortNumber());
            logger.log(Level.INFO,"Waiting for client to connect...");
            while (true) {
                Socket socket = serverSocket.accept();
                clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (BindException e) {
            logger.log(Level.INFO,"Unable to start the simulator on port number " + Main.simulatorProperties.getPortNumber());
        } catch (SocketException e) {
            logger.log(Level.DEBUG,"Server stopped.");
        } catch (IOException e) {
            logger.log(Level.FATAL,"Unable to create the server socket due to error " + e);
        }
    }
}
