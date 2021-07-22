/**
 * [通过参数名获取url中的参数值]
 * 示例URL:http://htmlJsTest/getrequest.html?uid=admin&rid=1&fid=2&name=小明
 * @param  {[string]} queryName [参数名]
 * @return {[string]}           [参数值]
 */
function getQueryValueWithVersion(queryName) {
    var reg = new RegExp("(^|&)" + queryName + "=([^&]*)(&|$)", "i");
	var url = "";
	if(window.location.search.length > 6) {
		url = window.location.search.substr(1, window.location.search.length - 7);
	}
    var r = url.match(reg);
    if ( r != null ){
       return decodeURI(r[2]);
    }else{
       return null;
    }
 }
 
/**
 * [通过参数名获取url中的参数值]
 * 示例URL:http://htmlJsTest/getrequest.html?uid=admin&rid=1&fid=2&name=小明
 * @param  {[string]} queryName [参数名]
 * @return {[string]}           [参数值]
 */
function getQueryValue(queryName) {
    var reg = new RegExp("(^|&)" + queryName + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if ( r != null ){
       return decodeURI(r[2]);
    }else{
       return null;
    }
 }