package com.problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
Components of computer systems often have dependencies (i.e., other components that must be installed before the systems function properly). These dependencies are frequently shared by multiple components. For example, both the TELNET client program and the FTP client program require that the TCP/IP networking software be installed before they can operate. If you install TCP/IP and the TELNET client program, and later decide to add the FTP client program, you do not need to reinstall TCP/IP.
For some components, it would not be a problem if the components on which they depended were reinstalled; it would just waste some resources. For other components (e.g., TCP/IP), some component configuration may be destroyed if the component were reinstalled.
It is useful to be able to remove components that are no longer needed. When this is done, components that only support the removed component may also be removed, which frees up disk space, memory, and other resources. A supporting component that is not explicitly installed may be removed only if all components that depend on it are also removed. For example, removing the FTP client program and TCP/IP would mean the TELNET client program, which was not removed, would no longer operate. Likewise, removing TCP/IP by itself would cause the failure of both the TELNET and the FTP client programs. Also, if we installed TCP/IP to support our own development, then installed the TELNET client (which depends on TCP/IP), and then still later removed the TELNET client, we would not want TCP/IP to be removed.
Dependence is transitive.  For example, if A depends on B, and B depends on C, both B and C are implicitly installed when A is explicitly installed. Conversely, B and C would both be removed if A is subsequently removed. We need a program to automate the process of adding and removing components. To do this, we will maintain a record of installed components and component dependencies. A component can be installed explicitly in response to a command (unless it has already been explicitly installed), or implicitly if it is needed by some other component being installed. A component can be explicitly removed in response to a command (if it is not needed to support other components) or implicitly removed if it is no longer needed to support another component (and has not been explicitly installed).
1. Input
The input will contain a sequence of commands (as described below), each on a separate line that contains no more than 80 characters. Item names are case sensitive, and each is no longer than 10 characters. The command names (DEPEND, INSTALL, REMOVE, and LIST) always appear in uppercase starting in column one. Item names are separated from the command name and each other by one or more spaces. All appropriate DEPEND commands will appear before the occurrence of any INSTALL dependencies. The end of the input is marked by a line that contains only the word END.

Command Syntax 	                Interpretation/Response
DEPEND item1 item2 [item3...] 	item1 depends on item2 (and item3 ...)
INSTALL item1 	                install item1 and those on which it depends
REMOVE item1                    remove item1, and those on which it depends, if possible
LIST 	                          list the names of all currently-installed components

2. Output

Echo each line of input. Follow each echoed INSTALL or REMOVE line with the actions taken in response, making certain that the actions are given in the proper order. Also identify exceptional conditions. (See Expected Output, below, for examples of all cases.) For the LIST command, display the names of the currently installed components. No output, except the echo, is produced for a DEPEND command or the line containing END. There will be at most one dependency list per item.

3. Sample Input
22
DEPEND     TELNET TCPIP NETCARD
DEPEND TCPIP NETCARD
DEPEND NETCARD TCPIP
DEPEND DNS TCPIP NETCARD
DEPEND     BROWSER TCPIP HTML
INSTALL NETCARD
INSTALL TELNET
INSTALL foo
REMOVE NETCARD
INSTALL BROWSER
INSTALL DNS
LIST
REMOVE TELNET
REMOVE NETCARD
REMOVE DNS
REMOVE NETCARD
INSTALL NETCARD
REMOVE TCPIP
REMOVE BROWSER
REMOVE TCPIP
LIST
END



(Note: The first line in Sample input ‘n’ corresponds to the number of test cases followed by ‘n’ inputs)

4. Output for the Sample Output

DEPEND TELNET TCPIP NETCARD
DEPEND TCPIP NETCARD
DEPEND NETCARD TCPIP
TCPIP depends on NETCARD, ignoring command
DEPEND DNS TCPIP NETCARD
DEPEND BROWSER TCPIP HTML
INSTALL NETCARD
Installing NETCARD
INSTALL TELNET
Installing TCPIP
Installing TELNET
INSTALL foo
Installing foo
REMOVE NETCARD
NETCARD is still needed
INSTALL BROWSER
Installing HTML
Installing BROWSER
INSTALL DNS
Installing DNS
LIST
NETCARD
TCPIP
TELNET
foo
HTML
BROWSER
DNS
REMOVE TELNET
Removing TELNET
REMOVE NETCARD
NETCARD is still needed
REMOVE DNS
Removing DNS
REMOVE NETCARD
NETCARD is still needed
INSTALL NETCARD
NETCARD is already installed
REMOVE TCPIP
TCPIP is still needed
REMOVE BROWSER
Removing BROWSER
Removing TCPIP
Removing HTML
REMOVE TCPIP
TCPIP is not installed
LIST
NETCARD
foo
END

 */

public class SoftwareDependency {

  enum COMMAND {DEPEND, INSTALL, REMOVE, LIST, END}

  static class Software {

    private String name;
    private List<Software> dependencies;


    Software(String name) {
      this.name = name;
      dependencies = new ArrayList<>();
    }

    String getName() {
      return name;
    }

    List<Software> getDependencies() {
      return dependencies;
    }


    void addDependencies(Software dependency) {
      this.dependencies.add(dependency);
    }

    @Override
    public String toString() {
      return  this.name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Software)) {
        return false;
      }
      Software software = (Software) o;
      return Objects.equals(name, software.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }
  }

  private static Map<String, Software> allSoftware = new HashMap<>();

  private static List<Software> installedSoftware = new ArrayList<>();


  static void doIt(String[] input) {

    for (String inp : input) {
      System.out.println(inp);

      final String[] commandTokens = inp.split("\\s+");

      final String commandString = commandTokens[0];
      final COMMAND command = COMMAND.valueOf(commandString);

      switch (command) {
        case DEPEND:
          final String softwareName = commandTokens[1];
          buildDependencies(softwareName, commandTokens);
          break;
        case INSTALL:
          final Software softwareToBeInstalled = getSoftware(commandTokens[1]);
          if (isAlreadyInstalled(softwareToBeInstalled)) {
            System.out.println(softwareToBeInstalled + " is already installed");
          } else {
            //Install dependencies first
            final List<Software> softwareDependenciesToBeInstalled = softwareToBeInstalled.getDependencies();
            for (Software softwareDependency : softwareDependenciesToBeInstalled) {
              if (!isAlreadyInstalled(softwareDependency)) {
                install(softwareDependency);
              }
            }

            //Once the dependencies are installed, install the software
            install(softwareToBeInstalled);
          }
          break;
        case REMOVE:
          final Software softwareToBeRemoved = getSoftware(commandTokens[1]);
          if (!isAlreadyInstalled(softwareToBeRemoved)) {
            System.out.println(softwareToBeRemoved + " is not installed");
          }
          else if (canRemoveSoftware(softwareToBeRemoved)) {
            System.out.println("Removing " + softwareToBeRemoved);
            installedSoftware.remove(softwareToBeRemoved);

            final List<Software> currentSoftwareDependencies = softwareToBeRemoved.getDependencies();
            for (Software dependency : currentSoftwareDependencies) {
              if (canRemoveSoftware(dependency)) {
                System.out.println("Removing " + dependency);
                installedSoftware.remove(dependency);
              }
            }
          } else {
            System.out.println(softwareToBeRemoved + " is still needed");
          }
          break;
        case LIST:
          for (Software installedSoftware : installedSoftware) {
            System.out.println(installedSoftware);
          }
          break;
        case END:
          break;
      }
    }

  }

  private static void install(Software software) {
    System.out.println("Installing " + software);
    installedSoftware.add(software);
  }

  private static boolean isAlreadyInstalled(Software softwareToBeInstalled) {
    return installedSoftware.contains(softwareToBeInstalled);
  }

  private static void buildDependencies(String softwareName, String[] commandTokens) {
    //The dependencies of the current command are available from 3rd position onwards
    for (int i = 2; i < commandTokens.length; i++) {
      final String currentDependency = commandTokens[i];
      final List<Software> dependenciesOfdependency = getSoftware(currentDependency).getDependencies();

      if (dependenciesOfdependency != null && dependenciesOfdependency.contains(getSoftware(softwareName))) {
        System.out.println(
            currentDependency + " depends on " + softwareName + ", ignoring command");
      } else {
        getSoftware(softwareName).addDependencies(getSoftware(currentDependency));
      }

    }
  }

  private static Software getSoftware(String name) {
    Software software = allSoftware.get(name);
    if (software == null) {
      software = new Software(name);
      allSoftware.put(name, software);
    }
    return software;
  }

  private static boolean canRemoveSoftware(Software softwareToBeRemoved) {
    for (Software installedSoftware : installedSoftware) {
      final List<Software> requiredDependencies = installedSoftware.getDependencies();
      if (requiredDependencies != null) {
        for (Software dependency : requiredDependencies) {
          if (softwareToBeRemoved.equals(dependency)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args){
    /*Scanner in = new Scanner(System.in);

    int _input_size = 0;
    _input_size = Integer.parseInt(in.nextLine().trim());
    String[] _input = new String[_input_size];
    String _input_item;
    for(int _input_i = 0; _input_i < _input_size; _input_i++) {
      try {
        _input_item = in.nextLine();
      } catch (Exception e) {
        _input_item = null;
      }
      _input[_input_i] = _input_item;
    }

    doIt(_input);*/

    String[] inp = new String[]{"DEPEND TELNET TCPIP NETCARD",
        "DEPEND TCPIP NETCARD",
        "DEPEND NETCARD TCPIP",
        "DEPEND DNS TCPIP NETCARD",
        "DEPEND BROWSER TCPIP HTML",
        "INSTALL NETCARD",
        "INSTALL TELNET",
        "INSTALL foo",
        "REMOVE NETCARD",
        "INSTALL BROWSER",
        "INSTALL DNS",
        "LIST",
        "REMOVE TELNET",
        "REMOVE NETCARD",
        "REMOVE DNS",
        "REMOVE NETCARD",
        "INSTALL NETCARD",
        "REMOVE TCPIP",
        "REMOVE BROWSER",
        "REMOVE TCPIP",
        "LIST",
        "END"};

    doIt(inp);
  }
}
