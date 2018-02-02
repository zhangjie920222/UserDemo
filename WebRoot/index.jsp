<%@ page contentType="text/html;charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>	
	<title>登录系统</title>	
	<style type="text/css">
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
	      
	      margin-bottom:30px;
	   } 
	   #hangqright ul li span{
	     display:block;
	   }
	</style>
</head>
<body>
 <div style="height:40px;line-height:40px;width:1160px;margin:0 auto;margin-top:30px;">
          <div style="border:0;height:40px;line-height:40px;width:302px;float:right;background:url('images/searchbg.png')">
           <input type="text" style="padding-left:20px;out-line:0;height:40px;line-height:40px;width:302px;border:0;background:url('images/searchbtn.png')  right 30px center no-repeat"/>
          </div>
      </div>
      <div style="max-width:1160px;margin:0 auto;margin-top:30px">
         <table id="zhishutab" cellspacing="0" cellpadding="0" style="text-align:center;border:0">
         <thead style="background:#1578ce;color:white;height:60px;line-height:60px;">
           <tr>
           <th>产品编号</th>
           <th>产品名称</th>
           <th>最新价</th>
           <th>涨跌幅</th>
           <th>涨跌额</th>
           <th>成交量</th>
           </tr>
         </thead>
         <tbody>
           <tr class="trbg1">
           <th>00001</th>
           <th>0.30FLDVG</th>
           <th class="zhishud">12001</th>
           <th class="zhishud">-12%</th>
           <th class="zhishud">120</th>
           <th>1200</th>
           </tr>
           <tr class="trbg2">
           <th>00002</th>
           <th>0.30FLDVG</th>
           <th class="zhishuz">15001</th>
           <th class="zhishuz">+22%</th>
           <th class="zhishuz">320</th>
           <th>3200</th>
           </tr>
         </tbody>           
         </table>     
      </div>
<div style="width:1160px;margin:0 auto;">
   <div id="hangqleft" style="background:white;width:432px;float:left;padding:30px;">
       <div style="margin-bottom:20px;">
          <span style="margin-right:20px;">000001</span><span style="">030FLDVG</span>
       </div>
       <div style="margin-bottom:20px;">
       <span class="redbg">1234564</span>
       <span class="redz" style="color:red;float:right;">14.3</span>
       <span class="redz" style="color:red;float:right;margin-right:10px;">12.6%</span>
       </div>
       <a href="#" style="text-decoration:none;display:block;margin-top:30px"><div style="width:100%;background:#1578ce;height:30px;line-height:30px;margin:0 auto;text-align:center;color:white;cursor:pointer;text-decoration:none;padding:5px 0;">交易</div></a>
   </div>
   <div id="hangqright" style="background:white;float:left;">
       <div style="float:left;margin-right:60px;">
         <ul>
           <li>最高<span style="color:#f43a31;display:block;">128012</span></li>
           <li>最低<span style="color:#a1e4d3">128012</span></li>
           <li>平盘<span>128012</span></li>
         </ul>
       </div>
       <div style="float:left;margin-right:60px;">
          <ul>
           <li>今开<span>128012</span></li>
           <li>昨收<span>128012</span></li>
           <li>平均价<span>128012</span></li>
         </ul>
       </div>
       <div style="float:left;margin-right:60px;">
         <ul>
           <li>成交额<span>128012</span></li>
           <li>振幅<span>128012</span></li>         
         </ul>
       </div>
       <div style="float:left;margin-right:60px;">
         <ul>
           <li>上涨<span>128012</span></li>
           <li>下跌<span>128012</span></li>         
         </ul>
       </div>
      <div style="clear:both"></div>
   </div>
   <div style="clear:both;"></div>
</div>
</body>
</html>