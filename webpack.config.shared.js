'use strict';

var webpack = require('webpack');

module.exports = {
    plugins: [
        new webpack.NoEmitOnErrorsPlugin(),
    ],
    module: {
        rules: [
            {
                test: /\.css$/,
                use: [
                  { loader: 'style-loader' },
                  { loader: 'css-loader' }
                ]
            }, {
                test: /\.(png|jpg|gif|svg|eot|ttf|woff|woff2)$/,
                use: [
                  { loader: 'url-loader' }
                ],
                options: {
                    limit: 20000
                }
            }]
    }
};
