scalajs-react-android app
======================

Basic skeleton app for scalajs-react and scalacss

### Launch this project:

1. clone the project
a run below command from root of project folder
b sbt clean fastOptJS::webpack
c above command creats a target /AndroidApp/target/scala-2.12/scalajs-bundler/main
 copy above buindel and launcher.js files in to root project folder under js folder
d sudo npm install -g webpack@



2. In the project directory run:
a  in root project loaction edit index.html file with notepad and edit js script tags to
b`sbt ~fastOptJS`



3. On your browser go to:
a. http://localhost:12345/index.html
b. Note http://127.0.0.1:12345/ will not work only above one will work


4.Below are for material UI and google components
scalajs project we can add nodejs dependencies and build them



ashutosh@atp:~/Development/AndroidApp$ sbt webpack::version
[info] Loading global plugins from /home/ashutosh/.sbt/0.13/plugins
[info] Loading project definition from /home/ashutosh/Development/AndroidApp/project
[info] Set current project to scalajs-react-template (in build file:/home/ashutosh/Development/AndroidApp/)
[info] 2.6.1
ashutosh@atp:~/Development/AndroidApp$ npm version
{ npm: '6.0.0',
  ares: '1.10.1-DEV',
  http_parser: '2.8.0',
  icu: '58.2',
  modules: '48',
  node: '6.14.1',
  openssl: '1.0.2o',
  uv: '1.16.1',
  v8: '5.1.281.111',
  zlib: '1.2.11' }

┌────────────────────────────────────────────────────────────┐
│                  npm update check failed                   │
│            Try running with sudo or get access             │
│            to the local update config store via            │
│ sudo chown -R $USER:$(id -gn $USER) /home/ashutosh/.config │
└────────────────────────────────────────────────────────────┘





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