Remove-Item .\tomcat\tomcat-webapps\*.war
Start-Sleep -Seconds 1
Copy-Item -Path .\WebContent -Destination .\deploy\Webcontent -Container -Recurse
Copy-Item -Path ..\spring_lib\spring*.jar -Destination .\deploy\WebContent\WEB-INF\lib
Copy-Item -Path .\bin -Recurse -Destination .\deploy\WebContent\WEB-INF\classes

# Compress-Archive -Path .\deploy\WebContent -DestinationPath .\deploy\spring-mvc-demo.zip -CompressionLevel Fastest 
.\deploy-scripts\7zip\7za.exe a -r .\deploy\spring-mvc-demo.zip .\deploy\WebContent\*
Rename-Item -Path .\deploy\spring-mvc-demo.zip -NewName spring-mvc-demo.war

Copy-Item -Path .\deploy\spring-mvc-demo.war -Destination .\tomcat\tomcat-webapps
# clean deployment folder
Remove-Item .\deploy -Recurse