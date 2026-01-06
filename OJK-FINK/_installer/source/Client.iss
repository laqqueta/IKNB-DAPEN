;I.e. current directory will contain folder OJKClient with application files
[Setup]
AppId=FINKClient
AppName=FINK Client
AppVersion=1.1.0
AppVerName=FINK-Client 1.1.0
AppPublisher=OJK
AppComments=OJK FINK Client
AppCopyright=Copyright (C) 2020
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName=C:\OJK-FINK-Client
DisableStartupPrompt=Yes
;DisableDirPage=Yes
DisableDirPage=No
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=OJK
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,6.0 
OutputBaseFilename=030416-Client
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=Client.ico
UninstallDisplayIcon={app}\Client.ico
UninstallDisplayName=FINK-Client
WizardImageStretch=No
WizardSmallImageFile=Client-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=x64
CloseApplications=force

[Languages]
;Name: "english"; MessagesFile: "compiler:Default.isl"
;Name: "Indonesian"; MessagesFile: "compiler:Indonesian.isl"
Name: "Indonesian"; MessagesFile: "Indonesian.isl"

[Files]
;Source: "deploy\OjkClient.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "Client.ico"; DestDir: "{app}"; Flags: ignoreversion
Source: "..\deploy\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "..\..\..\jvm\*"; DestDir: "{app}\jvm\"; Flags: ignoreversion recursesubdirs createallsubdirs

[Setup]
SetupMutex=FINK-Client,Global\FINK-Client
OutputDir="..\ftp\app"

[Icons]
Name: "{group}\FINK-Client"; Filename: "{app}\OjkClient.exe"; IconFilename: "{app}\Client.ico"; Check: returnTrue()
Name: "{commondesktop}\FinkClient"; Filename: "{app}\OjkClient.exe";  IconFilename: "{app}\Client.ico"; Check: returnFalse()    

[Run]
Filename: "{app}\OjkClient.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\OjkClient.exe"; Description: "{cm:LaunchProgram,FINKClient}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\OjkClient.exe"; Parameters: "-install -svcName ""FINKClient"" -svcDesc ""FINKClient"" -mainExe ""OjkClient.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\OjkClient.exe "; Parameters: "-uninstall -svcName FINKClient -stopOnUninstall"; Check: returnFalse()
Filename: "{cmd}"; Parameters: "/C ""taskkill /im OjkClient.exe /f /t"

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  

procedure CurStepChanged(CurStep: TSetupStep);
var
  app, src, appSetup, srcSetup : ansistring;
  deleteResult, copyResult : boolean;

begin
  if CurStep=ssPostInstall then
  begin
    app := ExpandConstant('{app}');
    src := ExpandConstant('{src}');

    appSetup := app + '\\resources\\data.dat';
    srcSetup := src + '\\data.dat';

    deleteResult := DeleteFile(appSetup);
    copyResult := FileCopy(srcSetup, appSetup, True);
    if copyResult = False then
    begin
      MsgBox('gagal', mbError, mb_Ok);
    end           
  end 
end;
