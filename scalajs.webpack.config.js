module.exports = {
  "entry": {
    "scalajs-react-template-opt": ["C:\\Users\\h217119\\IdeaProjects\\ScalaJsWebApp\\js\\scalajs-react-template-opt.js"]
  },
  "output": {
    "path": "C:\\Users\\h217119\\IdeaProjects\\ScalaJsWebApp\\target\\scala-2.12\\scalajs-bundler\\main",
    "filename": "[name]-bundle.js"
  },
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "loader": "source-map-loader"
    }]
  }
}