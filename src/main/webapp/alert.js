function checkAll() {
    let password = document.getElementById("another-number").value;
    let sure = document.getElementById("company-name").value;
    if(password !== sure) {
        checkError();
    }
    // if(!e.value()) {
    //     window.alert("注册失败，请检查信息重新注册")
    // }
}
function checkError(){
    let passwordInput = document.getElementById("another-number");
    let sureInput = document.getElementById("company-name");
    passwordInput.value = "";  // 清空密码框的输入内容
    sureInput.value = "";     // 清空确认密码框的输入内容
    window.alert("两次密码输入不正确，请重新输入")
}