package com.seleniumProject.util.constants;

public class JsScripts {

    public static final String getXpathFull =
            "function createXPathFromElement(elm) { \n" +
                    "    var allNodes = document.getElementsByTagName('*'); \n" +
                    "    for (var segs = []; elm && elm.nodeType == 1; elm = elm.parentNode) \n" +
                    "    { \n" +
                    "        if (elm.hasAttribute('id')) { \n" +
                    "                var uniqueIdCount = 0; \n" +
                    "                for (var n=0;n < allNodes.length;n++) { \n" +
                    "                    if (allNodes[n].hasAttribute('id') && allNodes[n].id == elm.id) uniqueIdCount++; \n" +
                    "                    if (uniqueIdCount > 1) break; \n" +
                    "                }; \n" +
                    "                if ( uniqueIdCount == 1) { \n" +
                    "                    segs.unshift('id(\"' + elm.getAttribute('id') + '\")'); \n" +
                    "                    return segs.join('/'); \n" +
                    "                } else { \n" +
                    "                    segs.unshift(elm.localName.toLowerCase() + '[@id=\"' + elm.getAttribute('id') + '\"]'); \n" +
                    "                } \n" +
                    "        } else if (elm.hasAttribute('class')) { \n" +
                    "            segs.unshift(elm.localName.toLowerCase() + '[@class=\"' + elm.getAttribute('class') + '\"]'); \n" +
                    "        } else { \n" +
                    "            for (i = 1, sib = elm.previousSibling; sib; sib = sib.previousSibling) { \n" +
                    "                if (sib.localName == elm.localName)  i++; }; \n" +
                    "                segs.unshift(elm.localName.toLowerCase() + '[' + i + ']'); \n" +
                    "        }; \n" +
                    "    }; \n" +
                    "    return segs.length ? '/' + segs.join('/') : null; \n" +
                    "}; " +
                    "    return createXPathFromElement(arguments[0]).toLowerCase();";


    public static final String getElementXpath = "gPt = function(c) {\n" +
            "    if (c.id !== '') {\n" +
            "        return 'id(\"' + c.id + '\")'\n" +
            "    }\n" +
            "    if (c === document.body) {\n" +
            "        return c.tagName\n" +
            "    }\n" +
            "    var a = 0;\n" +
            "    var e = c.parentNode.childNodes;\n" +
            "    for (var b = 0; b < e.length; b++) {\n" +
            "        var d = e[b];\n" +
            "        if (d === c) {\n" +
            "            return gPt(c.parentNode) + '/' + c.tagName + '[' + (a + 1) + ']'\n" +
            "        }\n" +
            "        if (d.nodeType === 1 && d.tagName === c.tagName) {\n" +
            "            a++\n" +
            "        }\n" +
            "    }\n" +
            "};\n" +
            "return gPt(arguments[0]).toLowerCase();";

    public static final String jsDropFile =
            "var target = arguments[0]," +
                    "    offsetX = arguments[1]," +
                    "    offsetY = arguments[2]," +
                    "    document = target.ownerDocument || document," +
                    "    window = document.defaultView || window;" +
                    "" +
                    "var input = document.createElement('INPUT');" +
                    "input.type = 'file';" +
                    "input.style.display = 'none';" +
                    "input.onchange = function () {" +
                    "  var rect = target.getBoundingClientRect()," +
                    "      x = rect.left + (offsetX || (rect.width >> 1))," +
                    "      y = rect.top + (offsetY || (rect.height >> 1))," +
                    "      dataTransfer = { files: this.files };" +
                    "" +
                    "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                    "    var evt = document.createEvent('MouseEvent');" +
                    "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                    "    evt.dataTransfer = dataTransfer;" +
                    "    target.dispatchEvent(evt);" +
                    "  });" +
                    "" +
                    "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                    "};" +
                    "document.body.appendChild(input);" +
                    "return input;";

    public static String getPageLoadTimeInMs = "return performance.timing.loadEventEnd - performance.timing.navigationStart;";

    public static String getPageCompleteState = "return  window.document.readyState;";

    public static String scrollToElement = "arguments[0].scrollIntoView(true);";

    public static String scrollToTop = "window.scrollTo(0, -document.body.scrollHeight)";

    public static String openNewPage = "window.open('your url','_blank');";
}
