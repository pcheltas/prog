package server;

import common.data.Worker;
import common.functional.Request;
import server.utils.*;
import server.commands.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunServer {
    private static final Logger logger = LogManager.getLogger(RunServer.class);

    public static void main(String[] args) {
        try {
            ResponseOutputer.appendln("main запущен");
            Loader loader = new Loader();
            CommandControl commandControl = new CommandControl(new Show(loader), new Clear(loader), new Help(loader),
                    new Insert(loader), new Info(loader), new Save(loader),
                    new ReplaceGreater(loader), new ReplaceLower(), new RemoveGreater(loader),
                    new PrintDesEndDate(loader), new RemoveKey(loader), new ExecuteScript(loader),
                    new Update(loader), new FilterGreaterSalary(loader), new RemoveByEndDate(loader), loader);
            RequestHandler requestHandler = new RequestHandler(commandControl);
            System.out.println("hello niggers");
            loader.filling();
//            List<Worker> setWorkers;
//            setWorkers = fileControl.readXmlFile();
//            System.out.println(setWorkers.size());
//            if (setWorkers != null) {
//                for (Worker worker : setWorkers) {
//                    loader.addToCollection(worker);
//                }
//            }
            Server server = new Server(port , requestHandler);
            server.connection();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Ошибка при работе с сокетом");
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Произошла неожиданная ошибка");
            //e.printStackTrace();
        }

    }
}
