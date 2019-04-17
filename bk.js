//生成随机银行卡号
function getBankAccount() {

    // var bank_no = document.getElementById("bank_no_select").value; 
    var bank_no = '0102';
    var prefix = "";
    switch (bank_no) {
    case "0102":
        prefix = "622202";
        break;
    case "0103":
        prefix = "622848";
        break;
    case "0105":
        prefix = "622700";
        break;
    case "0301":
        prefix = "622262";
        break;
    case "104":
        prefix = "621661";
        break;
    case "0303":
        prefix = "622666";
        break;
    case "305":
        prefix = "622622";
        break;
    case "0306":
        prefix = "622556";
        break;
    case "0308":
        prefix = "622588";
        break;
    case "0410":
        prefix = "622155";
        break;
    case "302":
        prefix = "622689";
        break;
    case "304":
        prefix = "622630";
        break;
    case "309":
        prefix = "622908";
        break;
    case "310":
        prefix = "621717";
        break;
    case "315":
        prefix = "622323";
        break;
    case "316":
        prefix = "622309";
        break;
    default:
    }

    for (var j = 0; j < 13; j++) {
        prefix = prefix + Math.floor(Math.random() * 10);
    }

    // var x = document.getElementsByName("bank_no");
    // for (var i = 0; i < x.length; i++) {
    //     var o = x[i];
    //     o.value = bank_no;
    // }
    // var y = document.getElementsByName("bank_account");
    // for (var i = 0; i < y.length; i++) {
    //     var o = y[i];
    //     o.value = prefix;
    // }
    return prefix;
}