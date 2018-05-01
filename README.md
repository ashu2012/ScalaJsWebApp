scalajs-react-android app
======================

Basic skeleton app for scalajs-react and scalacss

### Launch this project:

1. clone the project
run below command from root of project folder
1.b sbt clean fastOptJS::webpack
1.c above command creats a target /AndroidApp/target/scala-2.12/scalajs-bundler/main
 copy above buindel and launcher.js files in to root project folder under js folder




2. In the project directory run:
2.a  in root project loaction edit index.html file with notepad and edit js script tags to
2.b`sbt ~fastOptJS`



3. On your browser go to:
http://localhost:12345/index.html
Note http://127.0.0.1:12345/ will not work only above one will work


4.Below are for material UI and google components
scalajs project we can add nodejs dependencies and build them

nodejs minimum =6
Realted package installation
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -

echo "Installing NodeJS 6.x"
sudo apt-get install nodejs

echo "Install webpack globally"
sudo npm install webpack -g

echo "Install nightwatch globally"
sudo npm install webpack -g

sudo npm install -g brunch

echo "Install Selenium standalone globally"
sudo npm install selenium-standalone@latest -g
sudo selenium-standalone install

echo "Installing Yarn"
curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
sudo apt-get update && sudo apt-get install yarn -y --allow-unauthenticated

echo "Installing driver"
#sudo selenium-standalone install --drivers.chrome.version=2.29 --drivers.chrome.baseURL=https://chromedriver.storage.googleapis.com

#selenium-standalone start install -y nodejs