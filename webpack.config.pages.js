let entries = {
    index: './src/main/js/index.js',
    import: './src/main/js/import.js',
};
let pagesConfig = [
    { chunks: ["import", "index"], template: 'raw-loader!./src/main/webapp/index.xhtml', inject: 'body', filename: 'index.xhtml'},
    { chunks: [], template: 'raw-loader!./src/main/webapp/page.xhtml', inject: false, filename: 'page.xhtml'},
];

module.exports = {
    entries,pagesConfig
}