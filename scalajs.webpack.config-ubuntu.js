module.exports = {
  "entry": {
    "scalajs-react-template-opt": ["/home/ashutosh/Development/ScalaJsWebApp/js/scalajs-react-template-opt.js"]
  },
  "output": {
    "path": "/home/ashutosh/Development/ScalaJsWebApp/target/scala-2.12/scalajs-bundler/main",
    "filename": "[name]-bundle.js"
  },
  "mode": "development",
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "use": ["source-map-loader"]
    }]
  }
}