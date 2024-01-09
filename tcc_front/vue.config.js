module.exports = {
  lintOnSave: false,
  runtimeCompiler: true,
  configureWebpack: {
    resolve: {
       symlinks: false
    },
    devtool: 'source-map',
  },
  transpileDependencies: [
    '@coreui/utils'
  ],
  publicPath: process.env.NODE_ENV === "development" ? "/" : "../../../tcc", 
}