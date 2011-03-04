/*
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

Ext.onReady(function() {

    Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

    var myData = [
        ['3m Co',71.72,0.02,0.03,'9/1 12:00am'],
        ['Alcoa Inc',29.01,0.42,1.47,'9/1 12:00am'],
        ['Altria Group Inc',83.81,0.28,0.34,'9/1 12:00am'],
        ['American Express Company',52.55,0.01,0.02,'9/1 12:00am'],
        ['American International Group, Inc.',64.13,0.31,0.49,'9/1 12:00am'],
        ['AT&T Inc.',31.61,-0.48,-1.54,'9/1 12:00am'],
        ['Boeing Co.',75.43,0.53,0.71,'9/1 12:00am'],
        ['Caterpillar Inc.',67.27,0.92,1.39,'9/1 12:00am'],
        ['Citigroup, Inc.',49.37,0.02,0.04,'9/1 12:00am'],
        ['E.I. du Pont de Nemours and Company',40.48,0.51,1.28,'9/1 12:00am'],
        ['General Electric Company',34.14,-0.08,-0.23,'9/1 12:00am'],
        ['General Motors Corporation',30.27,1.09,3.74,'9/1 12:00am'],
        ['Hewlett-Packard Co.',36.53,-0.03,-0.08,'9/1 12:00am'],
        ['Honeywell Intl Inc',38.77,0.05,0.13,'9/1 12:00am'],
        ['Intel Corporation',19.88,0.31,1.58,'9/1 12:00am'],
        ['International Business Machines',81.41,0.44,0.54,'9/1 12:00am'],
        ['Johnson & Johnson',64.72,0.06,0.09,'9/1 12:00am'],
        ['JP Morgan & Chase & Co',45.73,0.07,0.15,'9/1 12:00am'],
        ['McDonald\'s Corporation',36.76,0.86,2.40,'9/1 12:00am'],
        ['Merck & Co., Inc.',40.96,0.41,1.01,'9/1 12:00am'],
        ['Pfizer Inc',27.96,0.4,1.45,'9/1 12:00am'],
        ['The Coca-Cola Company',45.07,0.26,0.58,'9/1 12:00am'],
        ['The Home Depot, Inc.',34.64,0.35,1.02,'9/1 12:00am'],
        ['The Procter & Gamble Company',61.91,0.01,0.02,'9/1 12:00am'],
        ['United Technologies Corporation',63.26,0.55,0.88,'9/1 12:00am'],
        ['Verizon Communications',35.57,0.39,1.11,'9/1 12:00am']
    ];

    function change(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    }

    function pctChange(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }

    var store = new Ext.data.SimpleStore({
        fields: [
            {name: 'company'},
            {name: 'price', type: 'float'},
            {name: 'change', type: 'float'},
            {name: 'pctChange', type: 'float'},
            {name: 'lastChange', type: 'date', dateFormat: 'n/j h:ia'}
        ]
    });
    store.loadData(myData);

    var datagrid = new Ext.grid.GridPanel({
        id:'datagrid',
        store: store,
        columns: [
            {id:'company',header: "Company", width: 160, sortable: true, dataIndex: 'company'},
            {header: "Price", width: 75, sortable: true, renderer: 'usMoney', dataIndex: 'price'},
            {header: "Change", width: 75, sortable: true, renderer: change, dataIndex: 'change'},
            {header: "% Change", width: 75, sortable: true, renderer: pctChange, dataIndex: 'pctChange'},
            {header: "Last Updated", width: 85, sortable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'), dataIndex: 'lastChange'}
        ],
        stripeRows: true,
        autoExpandColumn: 'company',
        height:350,
        width:600,
        title:'Grid'
    });

    datagrid.render(document.body);
    datagrid.getSelectionModel().selectFirstRow();

    var datagrid_disabled = new Ext.grid.GridPanel({
        id:'datagrid_disabled',
        store: store,
        disabled: true,
        columns: [
            {id:'company',header: "Company", width: 160, sortable: true, dataIndex: 'company'},
            {header: "Price", width: 75, sortable: true, renderer: 'usMoney', dataIndex: 'price'},
            {header: "Change", width: 75, sortable: true, renderer: change, dataIndex: 'change'},
            {header: "% Change", width: 75, sortable: true, renderer: pctChange, dataIndex: 'pctChange'},
            {header: "Last Updated", width: 85, sortable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'), dataIndex: 'lastChange'}
        ],
        stripeRows: true,
        autoExpandColumn: 'company',
        height:350,
        width:600,
        title:'Grid'
    });

    datagrid_disabled.render(document.body);

    var datagrid_hidden = new Ext.grid.GridPanel({
        id:'datagrid_hidden',
        store: store,
        hidden: true,
        columns: [
            {id:'company',header: "Company", width: 160, sortable: true, dataIndex: 'company'},
            {header: "Price", width: 75, sortable: true, renderer: 'usMoney', dataIndex: 'price'},
            {header: "Change", width: 75, sortable: true, renderer: change, dataIndex: 'change'},
            {header: "% Change", width: 75, sortable: true, renderer: pctChange, dataIndex: 'pctChange'},
            {header: "Last Updated", width: 85, sortable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'), dataIndex: 'lastChange'}
        ],
        stripeRows: true,
        autoExpandColumn: 'company',
        height:350,
        width:600,
        title:'Grid'
    });

    datagrid_hidden.render(document.body);

    new Ext.Button({
        applyTo: 'error',
        id: 'gridError',
        text: 'Button'
    });

});