// Generated using webpack-cli https://github.com/webpack/webpack-cli

const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const WorkboxWebpackPlugin = require('workbox-webpack-plugin');

const ImageMinimizerPlugin = require("image-minimizer-webpack-plugin");
const WebpackObfuscator = require('webpack-obfuscator');

const isProduction = process.env.NODE_ENV == 'production';


const stylesHandler = MiniCssExtractPlugin.loader;

const {entries, pagesConfig} = require('./webpack.config.pages.js');


const config = {
    entry: entries,
    output: {
        filename: 'js/[name].bundle.js',
        path: path.resolve(__dirname, 'dist'),
    },
    plugins: [

        new MiniCssExtractPlugin({
            filename: "css/[name].[hash].css"
        }),

        // Add your plugins here
        // Learn more about plugins from https://webpack.js.org/configuration/plugins/
    ],
    module: {
        rules: [
            {
                test: /\.jsp$/,
                loader: 'string-replace-loader',
                options: {
                    search: '#\\{',
                    replace(match, p1, offset, string) {
                        return "${"
                    },
                    flags: 'g'
                }
            },
            {
                test: /\.(js|jsx)$/i,
                loader: 'babel-loader',
            },
            {
                test: /\.s[ac]ss$/i,
                use: [stylesHandler, 'css-loader', 'postcss-loader', 'sass-loader'],
            },
            {
                test: /\.css$/i,
                use: [stylesHandler, 'css-loader', 'postcss-loader'],
            },
            {
                test: /\.(eot|svg|ttf|woff|woff2|png|jpg|gif)$/i,
                type: 'asset',
            },

            // Add your rules for custom modules here
            // Learn more about loaders from https://webpack.js.org/loaders/
        ],
    },
};

module.exports = () => {
    config.plugins = pagesConfig.map(page => new HtmlWebpackPlugin(page)).concat(config.plugins);
    if (isProduction) {
        config.mode = "production";
        config.optimization = {
            chunkIds:false,
            minimize: false,
            removeAvailableModules: true,
            splitChunks: {
                chunks: 'async',
                minSize: 20000,
                maxSize: 256000,
                minRemainingSize: 0,
                minChunks: 1,
                maxAsyncRequests: 30,
                maxInitialRequests: 30,
                enforceSizeThreshold: 50000,
                cacheGroups: {
                    defaultVendors: {
                        test: /[\\/]node_modules[\\/]/,
                        priority: -10,
                        reuseExistingChunk: true,
                    },
                    default: {
                        minChunks: 2,
                        priority: -20,
                        reuseExistingChunk: true,
                    },
                },
            },
        };

        // config.plugins.push(new WorkboxWebpackPlugin.GenerateSW());
        /*config.plugins.push(
            new ImageMinimizerPlugin({
                minimizer: {
                    implementation: ImageMinimizerPlugin.squooshMinify,
                    options: {
                        mozjpeg: {}, //an empty object means 'use default settings'
                        jxl: {
                            quality: 90,
                        },
                    },
                },
            }));*/
        config.plugins.push(new WebpackObfuscator({
            renameGlobals: false,
            renameProperties: false,
            deadCodeInjection: false,
            rotateStringArray: true,
            debugProtection: false,
            disableConsoleOutput: true,
            selfDefending: true,
            stringArray: true,
            stringArrayRotate: true,
            stringArrayShuffle: true,
            stringArrayThreshold: 1,
            stringArrayIndexShift: true,
            stringArrayWrappersCount: 2,
            stringArrayWrappersType: 'function',
            stringArrayWrappersParametersMaxCount: 4,
            stringArrayEncoding: ['base64'],
            splitStrings: true,
            splitStringsChunkLength:10,
            transformObjectKeys: true,
            numbersToExpressions: true,
            controlFlowFlattening: true
        }, ['js/import.bundle.js']));
    } else {
        config.mode = "development";
    }
    return config;
};
