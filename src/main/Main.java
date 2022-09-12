package main;

import java.util.Scanner;


import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
	//display a specific note 
	
	public static void list(String str) throws FileNotFoundException {
		File file = new File(System.getProperty("user.home")+"/Desktop/Notes/"+str+".txt");
		Scanner scan = new Scanner(file);
		
		System.out.println(scan.nextLine());
		scan.close();
	}
	
	//display all methods
	
	public static void list() {
		try {

            
            File notesFolder = new File(System.getProperty("user.home")+"/Desktop/Notes/");
            File[] notesInFolder = notesFolder.listFiles();
            for(int i=0; i<notesInFolder.length; i++) {
            	System.out.println("Your notes are:");
            	System.out.println(notesInFolder[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	//rename a list
	
	public static void rename(String title, String newTitle) {
		
		try {
		File note = new File(System.getProperty("user.home")+"/Desktop/Notes/"+title+".txt");
		File newNote = new File(System.getProperty("user.home")+"/Desktop/Notes/"+newTitle+".txt");
		boolean exist=false;
		//search for the title in the notes
		File notesFolder = new File(System.getProperty("user.home")+"/Desktop/Notes/");
        File[] notesInFolder = notesFolder.listFiles();
        for(int i=0; i<notesInFolder.length; i++) {
        	if(notesInFolder[i].equals(note))exist=true;
        }
		
		
		if(exist==true) {
		note.renameTo(newNote);
		System.out.println("Renamed");
		}
		else {
	        System.out.println("No note with the title '"+title+"' could be found");
	        }
		
	} catch (Exception e) {
        e.printStackTrace();
    }
		
	}
	

	//create a note
	
	public static void add(String title, String[] content) throws IOException {
		
		String path="/Users/vladturcu/Desktop/Notes/"+title+".txt";
		
		String array =String.join(" ",content); 
		
		 try {

	            
	            Files.write(
	                    Paths.get(path),
	                    array.getBytes(StandardCharsets.UTF_8));

	            
	    		System.out.println("Note with title '"+title+"' saved!");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
	}
	
	// delete a note
	
public static void remove(String title) {
		
		try {
		
		File note = new File(System.getProperty("user.home")+"/Desktop/Notes/"+title+".txt");
		
		boolean exist=false;
		//search for the title in the notes
		File notesFolder = new File(System.getProperty("user.home")+"/Desktop/Notes/");
        File[] notesInFolder = notesFolder.listFiles();
        for(int i=0; i<notesInFolder.length; i++) {
        	if(notesInFolder[i].equals(note))exist=true;
        }
		
		
		if(exist==true) {
		Files.delete(note.toPath());
		System.out.println("Deleted!");
		}
		else {
	        System.out.println("No note with the title '"+title+"' could be found");
	        }
		
	} catch (Exception e) {
        e.printStackTrace();
    }
		
	}
	
	
	
	/*	
	 * 
	 * old methods with different logic
	 * 
	 * 
public static void list() {
	
	try {
        File f = new File("/Users/vladturcu/Desktop/Notes/");

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                
                return name.endsWith(".txt");
            }
        };

        File[] files = f.listFiles(filter);

        
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}



public static void add(String title, String[] content) throws IOException {
	FileWriter writer = new FileWriter("/Users/vladturcu/Desktop/Notes/"+title+".txt");
	for(int i=0; i<content.length; i++)
	writer.write(content[i]+" ");
	writer.close();
	System.out.println("Note with title '"+title+"' saved!");
}
*/
	
	public static void main(String[] args) throws IOException {
		
	        
	        
	        if(args[0].equals("-list") && args.length == 1) {
				list();
			}
	        
			else
			if(args[0].equals("-list") && args.length == 2) {
				String title=args[1];
				list(title);
				
			}
			
			else
				if(args[0].equals("-add") && args.length >= 3 ) {
				
			String title=args[1];
			String[] content = new String[args.length-2];
			
			for(int i=2; i<args.length; i++)
			{
				content[i-2]=args[i];
			}
			
			add(title,content);
			
			
			}
			
				else if(args[0].equals("-add") && args.length < 2 ) {
					System.out.println("No content!");
					
				}
	        
	        
				else if(args[0].equals("-rename") && args.length >= 3 ) {
					String title=args[1];
					String newTitle=args[2];
					rename(title, newTitle);
					
					
				}
				else if(args[0].equals("-rename") && args.length < 3 ) {
					System.out.println("No correct rename format! Correct command: rename <current title> <old title>");
					
				}
				else if(args[0].equals("-remove") && args.length == 2 ) {
					String title=args[1];
					
					remove(title);
					

					
				}
				else if(args[0].equals("-remove") && args.length < 2 ) {
					System.out.println("No correct rename format! Correct commands: remove <title> =");
					
				}
			else {System.out.println("The command does not exists. Please use one of the following command: ");
			System.out.println("-list");
			System.out.println("-list <title>");
			System.out.println("-add <title> <content>");
			System.out.println("-remove <title>");
			System.out.println("-rename <current title> <old title>");
			
			}
			
			
			
			
	        
	    }
	}

