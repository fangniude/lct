echo off

rem set window title
title LCT

rem home dir
cd ..

rem class path
set CP=.\classes;.\conf
for %%J in (.\lib\*.jar) do call :add_cp .\lib %%J

rem jvm param
set OPTS=-server -Xms512M -Xmx512M -Xss512k

echo OPTS: %OPTS%
echo CLASSPATH: %CP%
echo.
java -Djava.security.policy=.\java.policy %OPTS% -cp %CP%  -Ddvm.mode.lct=true com.winnertel.ems.lct.LctMain LCT

pause
cmd

rem use function for add class path
:add_cp
set CP=%CP%;%1\%~snx2
goto :eof



