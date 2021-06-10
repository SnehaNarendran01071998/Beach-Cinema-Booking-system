const path = require("path");
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
