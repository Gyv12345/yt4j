let api = [];
api.push({
    alias: 'api',
    order: '1',
    desc: '简单demo演示',
    link: '简单demo演示',
    list: []
})
api[0].list.push({
    order: '1',
    desc: '测试什么',
});
api[0].list.push({
    order: '2',
    desc: '',
});
api.push({
    alias: 'SysDeptController',
    order: '2',
    desc: '部门(SysDept)表控制层',
    link: '部门(sysdept)表控制层',
    list: []
})
api[1].list.push({
    order: '1',
    desc: '机构树',
});
api[1].list.push({
    order: '2',
    desc: '分页查询所有数据d',
});
api[1].list.push({
    order: '3',
    desc: '通过主键查询单条数据',
});
api[1].list.push({
    order: '4',
    desc: '新增数据',
});
api[1].list.push({
    order: '5',
    desc: '修改数据',
});
api[1].list.push({
    order: '6',
    desc: '删除数据',
});
api.push({
    alias: 'SysDictController',
    order: '3',
    desc: '字典(SysDict)表控制层',
    link: '字典(sysdict)表控制层',
    list: []
})
api[2].list.push({
    order: '1',
    desc: '',
});
api[2].list.push({
    order: '2',
    desc: '分页查询所有数据',
});
api[2].list.push({
    order: '3',
    desc: '通过主键查询单条数据',
});
api[2].list.push({
    order: '4',
    desc: '新增数据',
});
api[2].list.push({
    order: '5',
    desc: '修改数据',
});
api[2].list.push({
    order: '6',
    desc: '删除数据',
});
api.push({
    alias: 'SysDictItemController',
    order: '4',
    desc: '(SysDictItem)表控制层',
    link: '(sysdictitem)表控制层',
    list: []
})
api[3].list.push({
    order: '1',
    desc: '分页查询所有数据',
});
api[3].list.push({
    order: '2',
    desc: '通过主键查询单条数据',
});
api[3].list.push({
    order: '3',
    desc: '新增数据',
});
api[3].list.push({
    order: '4',
    desc: '',
});
api[3].list.push({
    order: '5',
    desc: '修改数据',
});
api[3].list.push({
    order: '6',
    desc: '删除数据',
});
api.push({
    alias: 'SysMenuController',
    order: '5',
    desc: '资源权限(SysMenu)表控制层',
    link: '资源权限(sysmenu)表控制层',
    list: []
})
api[4].list.push({
    order: '1',
    desc: '通过应用ID获取菜单',
});
api[4].list.push({
    order: '2',
    desc: '',
});
api[4].list.push({
    order: '3',
    desc: '',
});
api[4].list.push({
    order: '4',
    desc: '分页查询所有数据',
});
api[4].list.push({
    order: '5',
    desc: '通过主键查询单条数据',
});
api[4].list.push({
    order: '6',
    desc: '新增数据',
});
api[4].list.push({
    order: '7',
    desc: '修改数据',
});
api[4].list.push({
    order: '8',
    desc: '删除数据',
});
api.push({
    alias: 'SysRoleController',
    order: '6',
    desc: '角色(SysRole)表控制层',
    link: '角色(sysrole)表控制层',
    list: []
})
api[5].list.push({
    order: '1',
    desc: '',
});
api[5].list.push({
    order: '2',
    desc: '',
});
api[5].list.push({
    order: '3',
    desc: '',
});
api[5].list.push({
    order: '4',
    desc: '分页查询所有数据',
});
api[5].list.push({
    order: '5',
    desc: '通过主键查询单条数据',
});
api[5].list.push({
    order: '6',
    desc: '新增数据',
});
api[5].list.push({
    order: '7',
    desc: '修改数据',
});
api[5].list.push({
    order: '8',
    desc: '删除数据',
});
api.push({
    alias: 'SysUserController',
    order: '7',
    desc: '用户(SysUser)表控制层',
    link: '用户(sysuser)表控制层',
    list: []
})
api[6].list.push({
    order: '1',
    desc: '',
});
api[6].list.push({
    order: '2',
    desc: '',
});
api[6].list.push({
    order: '3',
    desc: '',
});
api[6].list.push({
    order: '4',
    desc: '',
});
api[6].list.push({
    order: '5',
    desc: '分页查询所有数据',
});
api[6].list.push({
    order: '6',
    desc: '通过主键查询单条数据',
});
api[6].list.push({
    order: '7',
    desc: '新增数据',
});
api[6].list.push({
    order: '8',
    desc: '重置用户密码',
});
api[6].list.push({
    order: '9',
    desc: '修改数据',
});
api[6].list.push({
    order: '10',
    desc: '删除数据',
});
document.onkeydown = keyDownSearch;
function keyDownSearch(e) {
    const theEvent = e;
    const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code == 13) {
        const search = document.getElementById('search');
        const searchValue = search.value;
        let searchArr = [];
        for (let i = 0; i < api.length; i++) {
            let apiData = api[i];
            const desc = apiData.desc;
            if (desc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                searchArr.push({
                    order: apiData.order,
                    desc: apiData.desc,
                    link: apiData.link,
                    alias: apiData.alias,
                    list: apiData.list
                });
            } else {
                let methodList = apiData.list || [];
                let methodListTemp = [];
                for (let j = 0; j < methodList.length; j++) {
                    const methodData = methodList[j];
                    const methodDesc = methodData.desc;
                    if (methodDesc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                        methodListTemp.push(methodData);
                        break;
                    }
                }
                if (methodListTemp.length > 0) {
                    const data = {
                        order: apiData.order,
                        desc: apiData.desc,
                        alias: apiData.alias,
                        link: apiData.link,
                        list: methodListTemp
                    };
                    searchArr.push(data);
                }
            }
        }
        let html;
        if (searchValue == '') {
            const liClass = "";
            const display = "display: none";
            html = buildAccordion(api,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        } else {
            const liClass = "open";
            const display = "display: block";
            html = buildAccordion(searchArr,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        }
        const Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            const links = this.el.find('.dd');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            const $el = e.data.el;
            $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp("20").parent().removeClass('open');
            }
        };
        new Accordion($('#accordion'), false);
    }
}

function buildAccordion(apiData, liClass, display) {
    let html = "";
    let doc;
    if (apiData.length > 0) {
         for (let j = 0; j < apiData.length; j++) {
            html += '<li class="'+liClass+'">';
            html += '<a class="dd" href="' + apiData[j].alias + '.html#header">' + apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
            html += '<ul class="sectlevel2" style="'+display+'">';
            doc = apiData[j].list;
            for (let m = 0; m < doc.length; m++) {
                html += '<li><a href="' + apiData[j].alias + '.html#_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + doc[m].desc + '</a> </li>';
            }
            html += '</ul>';
            html += '</li>';
        }
    }
    return html;
}