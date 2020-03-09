**Installing Newman**

1. Install NodeJS – https://nodejs.org/download/
2. Add the Node executable to your system path. Go to the Control Panel > System and Security > System > Advanced System Settings > Environment variables. Append this to the end of the PATH variable: ;C:\Program Files\Nodejs
If you installed Node in a different location, you’ll need to set the PATH accordingly.
3. Install Python 2.x. The latest 2.x release available is 2.7.9 (https://www.python.org/downloads/release/python-279/). Get the Windows x86-64 MSI installer or Windows x86 MSI installer, and follow the instructions.
4. Open a command prompt, and type “node”. The node environment should start. Press Ctrl-C to exit.
5. You’ll need to install the Visual Studio runtime for some Newman dependencies to be installed. The quickest way to do this is to install Visual Studio Express – http://go.microsoft.com/?linkid=9816758. To check for any additional requirements for your system, check https://github.com/TooTallNate/node-gyp (Windows).
6. Type “npm install -g newman”. It should take a few minutes to install.

**Downloading the JDK Installer**

1. In a browser, go to the Java SE Development Kit 10 Downloads page and click Accept License Agreement
2. Under the Download menu, click the Download link that corresponds to the .exe for your version of Windows.
3. Download the file jdk-10.interim.update.patch_windows-x64_bin.exe.

**Running the JDK Installer**

You must have administrator privilage to install the JDK on Microsoft Windows.

1. Start the JDK 10 installer by double-clicking the installer's icon or file name in the download location.
2. Follow the instructions provided by the Installation wizard.

**Setting the PATH Environment Variable**

To set the PATH variable permanently, add the full path of the jdk-10\bin directory to the PATH variable. Typically, the full path is:
C:\Program Files\Java\jdk-10\bin
To set the PATH variable on Microsoft Windows:
1. Select Control Panel and then System.
2. Click Advanced and then Environment Variables.
3. Add the location of the bin folder of the JDK installation to the PATH variable in System Variables.

The following is a typical value for the PATH variable:
C:\WINDOWS\system32;C:\WINDOWS;"C:\Program Files\Java\jdk-10\bin"

**Download and install IntelliJ IDEA**

1. Go to jetbrains.com/idea/ and click "Download" button
2. Choose the Windows tab and download "Community” version
2. Open .exe file and install without changes in installation wizard 