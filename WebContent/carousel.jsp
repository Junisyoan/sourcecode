<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<div id="banner-fade">
      <ul class="bjqs">
      <li><img src="<%=path%>image/index1/slide1.jpg" alt="" title="一时的挫折往往可以通过不屈的搏击，变成学问及见识。努力向上的开拓，才使弯曲的竹鞭化作了笔直的毛竹。"></li>
      <li><img src="<%=path%>image/index1/slide2.jpg" alt="" title="世上的事，只要肯用心去学，没有一件是太晚的。要始终保持敬畏之心，对阳光，对美，对痛楚。"></li>
      <li><img src="<%=path%>image/index1/slide3.jpg" alt="" title="时间就像一张网，你撒在哪里，你的收获就在哪里。纽扣第一颗就扣错了，可你扣到最后一颗才发现。有些事一开始就是错的，可只有到最后才不得不承认。"></li> 
      </ul>
</div>