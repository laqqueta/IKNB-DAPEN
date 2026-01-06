# OJK-Client
## 1. Quick Start
### a. Start Client
- In project root folder, execute `_build-generic-project.bat`
- Go to sector project folder (for example **OJK-ASRJK**), execute `_client-prepare-resources.bat [LJK-CODE]` for example `_client-prepare-resources.bat 2000000012`
- Still in the sector project folder, go to client project folder for example **OJK-ASRJK-Client**
- Still in the client project folder, if execution of `_client-prepare-resources.bat` succeed, you will see **data.dat** and **Client.properties** files in **resources** folder, 
- Still in the client project folder, execute `*ClientMain.java` as java application, for example `AsrjkClientMain.java`

### b. Generate Installer
- In project root folder, execute `_build-generic-project.bat`
- Go to sector project folder for example **OJK-ASRJK**, then execute `_build-installer.bat`
- Go to **_installer\ftp\app** folder, if execution of `_build-installer.bat`, you will see dat file for each LJK-CODE and application installer file for related sector
