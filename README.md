# phuchungha
phuchunghaweb
:root{
    --color: #Fbbc01;
}
* {
    padding:0;
    margin:0;
    box-sizing: border-box;
    font-family: 'Baloo Chettan 2',cursive;
}
li{
    list-style: none;
}
a{
    text-decoration:none;
}
header{
    width:100vw;
    header:1000vh;
    background: url(../images/);
    background-position:center;
    background-size: center;
    background-repeat: no-repeat;
    position: relative;
    display: flex;
    text-align: center;
    justify-content: center;
    align-items: center;
}
header::before{
    position: absolute;
    width: 100%;
    height: 100%;
    content: "";
    display: block;
    background:block;
    background:#rgba(0,0,0,0.5);
}
header input{
    width:50px;
    height:50px;
    position: absolute;
    top:12px;
    left:12px;
    opacity: 0.3;
    z-index: 2;
    cursor: pointer;
    position: fixed;
}
.menu-icon{
    width:50px;
    height:50px;
    position: absolute;
    top:12px;
    left:12px;
    opacity: 1;
    z-index: 1;
    cursor: pointer;
    position: fixed;
    display: flex;
    align-items: center;
    justify-content: center;
    
}
