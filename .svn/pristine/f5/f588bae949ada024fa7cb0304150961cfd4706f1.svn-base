//使用ajax加载数据字典,生成select(下拉选项)
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 需要回显时,选中哪个option
function loadSelect(param1, position, selectedname, selectedId) {
		var content = "<select name='"+selectedname+"'><option>----请选择----</option>";
		$.post("${pageContext.request.contextPath}/BaseDictAction", {
			"dict_type_code" : param1
		}, function(data) {
			$.each(data, function(i, json) {
					//判断是否需要回显 ,如果需要使其被选中
				if (json['dict_id'] == selectedId) {
					 content+="<option value='"+json['dict_id']+"' selected='selected'>"+json['dict_item_name']+"</option>";
				} else {
					content += "<option value='"+json['dict_id']+"'>"
							+ json['dict_item_name'] + "</option>";
				}
			});
			content += "</select>";
			//显示
			$("#" + position).html(content);
		}, "json"

		);

	}