const path = require("path");
var server_port = 8080 || process.env.PORT || 5000;
var server_host = "localhost" || "0.0.0.0";
module.exports = (env) => {
  return {
    mode: env ? "production" : "development",
    entry: path.resolve(__dirname, "/src/index.tsx"),
    output: {
      path: path.resolve(__dirname, "public/dist"),
      filename: "main.js",
    },
    devServer: {
      contentBase: ["./public"],
      open: true,
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "*",
        "Access-Control-Allow-Headers": "*",
        https: true,
      },
      historyApiFallback: true,
      port: server_port,
      host: server_host,
    },
    resolve: {
      extensions: [
        ".js",
        ".jsx",
        ".json",
        ".css",
        ".scss",
        ".ts",
        ".tsx",
        ".wasm",
        ".mjs",
      ],
      fallback: { crypto: false },
    },

    module: {
      rules: [
        {
          test: /\.tsx?$/,
          use: "ts-loader",
          exclude: /node_modules/,
        },
        {
          test: /\.s[ac]ss$/i,
          use: ["style-loader", "css-loader", "sass-loader"],
        },
        {
          test: /\.m?js/,
          resolve: {
            fullySpecified: false,
          },
        },
      ],
    },
  };
};
