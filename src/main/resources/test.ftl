package ${targetPackage};

public class ${className} {

<#list columns as row>
    public ${row.type} ${row.camelField};
</#list>

<#list columns as row>
    public ${row.type} get${row.camelField?cap_first}(){
        return ${row.camelField};
    }
    public void set${row.camelField?cap_first}(${row.type} ${row.camelField}){
        this.${row.camelField} = ${row.camelField};
    }
</#list>
}