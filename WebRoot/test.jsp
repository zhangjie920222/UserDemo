<%@ page contentType="text/html;charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>	
	<title>��ֵ˵��</title>	
	<meta charset="utf-8" />
    <script type="text/javascript" src="jquery-1.6.2.min.js"></script>
    <!--��IE8��IE9��֧��Html5��Css3-->
    <!--[if lte IE 8]>
        <script src="js/selectivizr.js"></script>
    <![endif]-->
    <!--[if lt IE 9]>
        <script src="js/css3-mediaqueries.js"></script>
        <script src="js/html5shiv.js"></script>
    <![endif]-->
    <style type="text/css">
       .hangqlieb{
         width:580px;
         float:left;
         text-align:center;
         color:black;      
       }
       .hangqliebcheck{
         width:580px;
         height:59px;
         float:left;
         text-align:center;
         color:white;
         background:url('images/zhishubg.png') center;     
      
       }
       .trbg1{
          background:#ccc;
          height:60px;
          line-height:60px;
       }
       .trbg2{
          background:#fff;
          height:60px;
          line-height:60px;
       }
       .zhishuz{
          color:red;
       }
       .zhishud{
          color:green;
       }
       #zhishutab th{
          width:193.01px;
       }
        .redz{
	      color:#f43a31;
	      border:2px solid #f43a31;
	      padding:5px 10px;
	      font-weight:bold;
	   }
	   .grennd{
	      color:#a1e4d3;
	      border:1px solid #a1e4d3;
	      padding:5px 10px;
	      font-weight:bold;
	   }
	   .redbg{
	     color:#f43a31;
	     font-size:24px;
	     background:url('images/ind_18.png') right center no-repeat;
	     margin-right:20px;
	     padding-right: 15px;
	   }
	   .greenbg{
	      font-size:16px;
	      background:url('images/ind_19.png') right 10px center no-repeat;
	      margin-right:20px;
	     padding-right: 15px;
	     color:#a1e4d3;
	   }
	   #hangqright ul{
	      list-style-type: none;
	   } 
	    #hangqright ul li{
	      height:30px;
	      float:left;
	      margin-bottom:30px;
	      min-width:190px;
	      text-align:center;
	   } 
	   #hangqright ul li span{
	     display:block;
	   }
	   #klinediv ul li {
	     list-style-type:none;
	     width:80px;
	     height:32px;
	     line-height:32px;
	     float:left;
	     text-align:center;
	   }
	   .klinebtnbg{
	     background:url('images/rikbg.png') center no-repeat; 
	     color:white;
	   }
	   /*���ie��Ĭ��ѡ�����ʽ���������������ͷ*/  
select::-ms-expand { 
display: none; 
} 
	   select {  
  /*Chrome��Firefox����ı߿��ǲ�һ���ģ����Ը�д��һ��*/  
  border: solid 1px #000;  
  
  /*�ܹؼ�����Ĭ�ϵ�selectѡ�����ʽ���*/  
   -webkit-appearance: none;
    -moz-appearance: none;
    appearance:none;
    background:none;
  /*��ѡ�������Ҳ��м���ʾС��ͷͼƬ*/  
  background: url("images/sale_17.png") no-repeat scroll right center transparent;  
  
  
  /*Ϊ����С��ͷ����һ��λ�ã����ⱻ���ָ���*/  
  padding-right: 14px;  
}  
  

    </style>
    </head>
    <body style="background:#3e4e68">
   <div style="height:49px;line-height:49px;width:1160px;margin:0 auto;background:white;">
         <div class="hangqlieb hangqliebcheck" id="zhuangshi">��ʯ����</div>
         <div class="hangqlieb" id="jiaoyisuo">����������</div>
         <div style="clear:both;"></div>
    </div>
     
   <div id="hangqidiv" style="width:1160px;margin:0 auto;margin-top:30px;min-height:150px;">
    <div id="hangqleft" style="background:white;width:230px;float:left;padding:30px;">
       <select>
           <option>--��ѡ��--</option>
           <option>0.3fldvg</option>
           <option>0.1fldvg</option>
       </select>
       <a href="#" style="text-decoration:none;display:block;margin-top:30px"><div style="width:100%;background:#1578ce;height:30px;line-height:30px;margin:0 auto;text-align:center;color:white;cursor:pointer;text-decoration:none;padding:5px 0;">����</div></a>
   </div>
   <div id="hangqright" style="min-height:150px;margin-left:30px;width:840px;background:white;float:left;padding:0">
       <div style="min-width:640px;padding:0;margin-top:30px;">
         <ul>
           <li>���<span style="color:#f43a31;display:block;">128012</span></li>
           <li>���<span style="color:#a1e4d3">128012</span></li>          
           <li>��<span>128012</span></li>
           <li>����<span>128012</span></li>          
         </ul>
       </div>
       <div style="min-width:640px;padding:0">
         <ul>
           <li>�ɽ���<span>128012</span></li>
           <li>���<span>128012</span></li>               
           <li>����<span>128012</span></li>
           <li>�µ�<span>128012</span></li>         
         </ul>
       </div>
      <div style="clear:both"></div>
   </div>
   <div style="clear:both;"></div>
</div>
<div id="klinediv" style="width:1160px;margin:0 auto;margin-top:30px;min-height:600px;background:white;">
<div style="padding-top:20px;">
  <ul>
    <li class="klinebtnbg">��Kͼ</li><li>��Kͼ</li><li>��Kͼ</li>
 </ul>
</div>
</div>
      <script>
        //��ʽ
        $(".hangqlieb").click(function(){
        	$(".hangqlieb").removeClass("hangqliebcheck");
        	$(this).addClass("hangqliebcheck"); 
        	var flag = $(this).attr("id");
        	if(flag=="zhuangshi"){
        		$("#hangqidiv").show();
        	}else{
        		$("#hangqidiv").hide();
        	}
        });
       $("#klinediv li").click(function(){
    	   $("#klinediv li").removeClass("klinebtnbg");
    	   $(this).addClass("klinebtnbg");
       });
      </script>
    </body>
    </html>