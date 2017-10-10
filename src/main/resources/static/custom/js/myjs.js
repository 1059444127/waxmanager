// timestamp转换成datetime
function timeStamp2String(time) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1;
    var date = datetime.getDate();
    var hour = datetime.getHours();
    var minute = datetime.getMinutes();
    var second = datetime.getSeconds();
    var mseconds = datetime.getMilliseconds();
    return p(year) + "-" + p(month) + "-" + p(date) + " " + p(hour) + ":" + p(minute) + ":" + p(second);
};

//创建补0函数
function p(s) {
    return s < 10 ? '0' + s : s;
}

// 格式化存放位置(B01F01C01N01-01柜第01层第01列第01个)
function formatLocation(location) {
    var box = location.substring(1, 3) + '柜';
    var float = '第' + location.substring(4, 6) + '层';
    var column = '第' + location.substring(7, 9) + '列';
    var number = '第' + location.substring(10, 12) + '个';
    return '<span style="color: black">' + box + '</span>' +
        '<span style="color: green">' + float + '</span>' +
        '<span style="color: #337ab7">' + column + '</span>' +
        '<span style="color: red">' + number + '</span>';
}
