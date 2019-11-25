package com.github.bdg91.tello.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.github.bdg91.tello.command.Command;
import com.github.bdg91.tello.command.control.BackCommand;
import com.github.bdg91.tello.command.control.CcwCommand;
import com.github.bdg91.tello.command.control.CommandCommand;
import com.github.bdg91.tello.command.control.CwCommand;
import com.github.bdg91.tello.command.control.ForwardCommand;
import com.github.bdg91.tello.command.control.LandCommand;
import com.github.bdg91.tello.command.control.LeftCommand;
import com.github.bdg91.tello.command.control.RightCommand;
import com.github.bdg91.tello.command.control.StreamOffCommand;
import com.github.bdg91.tello.command.control.StreamOnCommand;
import com.github.bdg91.tello.command.control.TakeOffCommand;
import com.github.bdg91.tello.command.read.ReadBaroCommand;
import com.github.bdg91.tello.command.read.ReadBatteryCommand;
import com.github.bdg91.tello.command.read.ReadTempCommand;
import com.github.bdg91.tello.command.read.ReadTimeCommand;
import com.github.bdg91.tello.command.read.ReadTofCommand;

public class run {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		TelloClient client = TelloClient.getInstance();
		
		Command commandCommand = new CommandCommand(client);
		Command readBaroCommand = new ReadBaroCommand(client);
		Command readBatteryCommand = new ReadBatteryCommand(client);
		Command readTempCommand = new ReadTempCommand(client);
		Command readTofCommand = new ReadTofCommand(client);
		Command readTimeCommand = new ReadTimeCommand(client);	
		Command streamOnCommand = new StreamOnCommand(client);
		Command streamOffCommand = new StreamOffCommand(client);

		try {
			commandCommand.execute();
			System.out.println("Info: Getting Status...");
			Thread.sleep(3000);
	        System.out.println("Info: Barometer: "+readBaroCommand.execute()+"m");
	        System.out.println("Info: Battery Level: "+readBatteryCommand.execute()+"%");
	        System.out.println("Info: Temperature: "+readTempCommand.execute()+" Celcius");
	        System.out.println("Info: Time: "+readTimeCommand.execute());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			commandCommand.execute();
			System.out.println("Info: Starting Stream...");
			Thread.sleep(4000);
			System.out.println("Stream On");
			streamOnCommand.execute();
			Thread.sleep(5000);	
			System.out.println("Stream Off");
			streamOffCommand.execute();
		} catch (IOException e) {
			e.printStackTrace();
		};
		/*
		
		Command commandCommand = new CommandCommand(client);
		Command takeOffCommand = new TakeOffCommand(client);
		Command cwCommand = new CwCommand(client, 360);
		Command ccwCommand = new CcwCommand(client, 360);
		Command forwardCommand = new ForwardCommand(client, 100);
		Command backCommand = new BackCommand(client, 100);
		Command leftCommand = new LeftCommand(client, 50);
		Command rightCommand = new RightCommand(client, 50);
		Command landCommand = new LandCommand(client);	
		
		 		List<Command> flightPlan_step1 = Arrays.
				asList(commandCommand, 
						takeOffCommand,
//						forwardCommand,
//						backCommand,
//						leftCommand,
//						rightCommand,
						cwCommand,
						ccwCommand,
						landCommand,
						readTofCommand,
						readBaroCommand,
						readBatteryCommand,
						readTempCommand);
		flightPlan_step1.forEach(command -> {
		    try {
		    	System.out.println("Info: Flight Plan 1 Beginning");
		        command.execute();
		        Thread.sleep(4000);
	        		System.out.println("Command: "+command.toString());
			        System.out.println("Info: Battery Level: "+readBatteryCommand.execute()+"%");
			        System.out.println("Info: Temperature: "+readTempCommand.execute()+" Celcius");
			        System.out.println("Info: Time of Flight: "+readTofCommand.execute());
		    } catch (Exception exception) {
		        // Exception handling
		    	System.out.println("Error: Exception in Flight Plan 1");
		    }
		    System.out.println("Info: Flight Plan 1 Complete");
		});
		*/
	}

}
