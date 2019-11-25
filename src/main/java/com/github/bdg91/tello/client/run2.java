package com.github.bdg91.tello.client;

import java.io.IOException;

import com.github.bdg91.tello.command.Command;
import com.github.bdg91.tello.command.read.ReadBatteryCommand;

public class run2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		TelloClient client = TelloClient.getInstance();
		
		Command readBatteryCommand = new ReadBatteryCommand(client);
		
		String bat = readBatteryCommand.execute();
		System.out.print(bat.toString());
		
		try {
			
		String bat2 = readBatteryCommand.execute();
		System.out.print(bat2.toString());
			
		}catch(Exception exception) {
			System.out.print(exception);
			}
		};


}
