select
===
	select #use("cols")# from admin  where  #use("condition")#

cols
===
	id,uname,pwd,nick,avatar,role,state,last_login_time,create_by,create_time,update_by,update_time

updateSample
===
	id=#id#,uname=#uname#,pwd=#pwd#,nick=#nick#,avatar=#avatar#,role=#role#,state=#state#,last_login_time=#lastLoginTime#,create_by=#createBy#,create_time=#createTime#,update_by=#updateBy#,update_time=#updateTime#

condition
===
	1=1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(uname)){
	 and uname=#uname#
	@}
	@if(!isEmpty(pwd)){
	 and pwd=#pwd#
	@}
	@if(!isEmpty(nick)){
	 and nick=#nick#
	@}
	@if(!isEmpty(avatar)){
	 and avatar=#avatar#
	@}
	@if(!isEmpty(role)){
	 and role=#role#
	@}
	@if(!isEmpty(state)){
	 and state=#state#
	@}
	@if(!isEmpty(lastLoginTime)){
	 and last_login_time=#lastLoginTime#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by=#updateBy#
	@}
	@if(!isEmpty(updateTime)){
	 and update_time=#updateTime#
	@}
	