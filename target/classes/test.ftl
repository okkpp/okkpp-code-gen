package ${package};

public class ${className} {

<#list fields as row>
    public ${row.type} ${row.name};
</#list>

<#list fields as row>
    public ${row.type} get${row.name?capitalize}(){
        return ${row.name};
    }
    public void set${row.name?capitalize}(${row.type} ${row.name}){
        this.${row.name} = ${row.name};
    }
</#list>
}