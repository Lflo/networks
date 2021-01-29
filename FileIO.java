import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

public class FileIO
{
    public SocialNetwork loadFile(SocialNetwork network, String fileName, String importType)
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;

        try
        {
            fileStrm = new FileInputStream(fileName);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            lineNum = 0;
            line = bufRdr.readLine();

            while(line != null)
            {
                lineNum++;
                try
                {
                    if (importType.equals("events")) 
                    {
                        processEvent(line, network, lineNum);
                    } else if (importType.equals("network")) 
                    {
                        processNetwork(line, network, lineNum);
                    }
                }
                catch(IllegalArgumentException e)
                {
                    throw new IllegalArgumentException(e.getMessage());
                }
                line = bufRdr.readLine();
            }
            
            fileStrm.close();
        }
        catch(IOException e)
        {
            if(fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                {}
            }

            throw new IllegalArgumentException("Error in file processing: " + 
                e.getMessage());
        }

        return network;
    } 
    
    public void processNetwork(String line, SocialNetwork network, int lineNum)
    {  
        try
        {
            String[] splitLine = line.split(":");
            if(splitLine.length == 1)
            {
                network.getNetwork().addUser(splitLine[0]);
            }
            else if (splitLine.length == 2) 
            {
                network.getNetwork().addFollower(splitLine[0], splitLine[1]);
            }
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("ERROR: network file: " + e.getMessage() + " on line " + 
                lineNum + "\n");
        }
    }

    public void processEvent(String line, SocialNetwork network, int lineNum)
    {  
        try
        {
            String[] splitLine = line.split(":");
            int length = splitLine.length;

            if(length > 1)
            {
                if(splitLine[0].length() != 1)
                {
                    throw new IllegalArgumentException("Event Type must be A, F or P");
                }
                else
                {
                    char eventType = splitLine[0].charAt(0);
                    if(eventType == 'A' && length == 2)
                    {
                        network.getNetwork().addUser(splitLine[1]);
                    }
                    else if(eventType == 'F' && length == 3)
                    {
                        network.getNetwork().addFollower(splitLine[1], splitLine[2]);
                    }
                    else if(eventType == 'P')
                    {
                        if (length == 3) 
                        {
                            network.addEvents(line);
                        }
                        else if (length == 4 && Integer.parseInt(splitLine[3]) > 0)
                        {
                            network.addEvents(line);
                        }
                    }
                    
                }
            }
            else
            {
                throw new IllegalArgumentException("Incorrect argument length");
            }
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("ERROR: events file: " + e.getMessage() + " on line " + 
                lineNum + "\n");
        }
    }
    public void saveFile(String output)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        String Filename = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.txt'").format(new Date());
        try
        {
            fileStrm = new FileOutputStream(Filename);
            pw = new PrintWriter(fileStrm);
            pw.println(output);
            pw.close();
        }
        catch(IOException e)
        {
            throw new IllegalArgumentException("ERROR: cannot write to file " +
            e.getMessage());
        }
    }
}