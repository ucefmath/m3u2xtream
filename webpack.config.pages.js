let entries = {
    index: './src/main/js/index.js',
    import: './src/main/js/import.js',
};
let pagesConfig = [{
    chunks: ["import", "index"],
    template: 'raw-loader!./src/main/webapp/index.jsp',
    inject: 'body',
    filename: 'index.jsp',
    chunksSortMode: "manual"
}];

module.exports = {
    entries,pagesConfig
}