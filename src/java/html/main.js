var NaCl = 153.8;
var NaHCO3 = 595;
var KCl = 1342;
var MgSO4 = 2083;
var CaCl2 = 450.5;
var Sugar = 277.8;
var totleVum = parseFloat("0");
var reg = /^\d+(\.\d+)?$/;
var inputs = new Array(7);
var outputs = new Array(7);

function handle() {
    totleVum = 0;
    inputs[0] = document.getElementById("cNaCl").value;
    inputs[1] = document.getElementById("cNaHCO3").value;
    inputs[2] = document.getElementById("cKCl").value;
    inputs[3] = document.getElementById("cMgSO4").value;
    inputs[4] = document.getElementById("cCaCl2").value;
    inputs[5] = document.getElementById("cSugar").value;
    inputs[6] = document.getElementById("water").value;

    for (var i =0 ;i < inputs.length; i++) {
        if (inputs[i]=="") {
            inputs[i] = 0;
            continue;
        }
        if(reg.test(inputs[i])==true){
            inputs[i] = parseFloat(inputs[i]);
        }else{
            alert("请输入数字，不要出现其他字符哦！");
            clearOutPut();
            return false;
        }
    }

    for (var i = 0; i < inputs.length; i++) {
        totleVum += inputs[i];
    }
    if (totleVum>0) {
        outputs[0] = (NaCl*inputs[0]+NaHCO3*inputs[1])/totleVum; //Na+
        outputs[1] = NaHCO3*inputs[1]/totleVum;   //HCO3-
        outputs[2] = KCl*inputs[2]/totleVum;    //K+
        outputs[3] = MgSO4*inputs[3]/totleVum;    //Mg2+
        outputs[4] = CaCl2*inputs[4]/totleVum;    //Ca2+
    }else{
        for (var i = 0; i < outputs.length; i++) {
            outputs[i] = 0;
        }
    }
    updateData();
    showResult();
}

function clearOutPut(){
    for (var i = 0; i < outputs.length; i++) {
        outputs[i] = 0;
    }
}

function initInputs(){
    for (var i =0 ;i < inputs.length; i++) {
        if (inputs[i]=="") {
            inputs[i] = 0;
            return true;
        }
        if(reg.test(inputs[i])==true){
            return true;
        }else{
            alert("请输入数字，不要出现其他字符哦！");
            return false;
        }
    }

}

function updateData(){
    document.getElementById("table1").style.visibility="visible";
    document.getElementById("Na+").innerHTML  = outputs[0].toFixed(2);
    document.getElementById("K+").innerHTML  = outputs[2].toFixed(2);
    document.getElementById("Ca2+").innerHTML  = outputs[4].toFixed(2);
    document.getElementById("Mg2+").innerHTML  = outputs[3].toFixed(2);
    document.getElementById("HCO3-").innerHTML  = outputs[1].toFixed(2);
}

function showResult() {
    var div= document.createElement("div");
    with(div.style){
        position="absolute";
        left="30%";
        top="30%";
    }
    div.innerHTML='<input type=button onclick="this.parentNode.style.display=\'none\'" value=关闭 /><br/><table border=1>'+document.getElementById('table1').innerHTML+'</table>';
    document.body.appendChild(div);
}