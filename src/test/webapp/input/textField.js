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

    var simple = new Ext.FormPanel({
        labelWidth: 75,
        frame:true,
        title: 'Simple Form',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',

        items: [
            {
                id: 'input_language',
                fieldLabel: 'Language',
                value: 'french',
                maxLength: 25
            }
        ]
    });

    simple.render(document.body);

    var mouseTests = new Ext.FormPanel({
        labelWidth: 75,
        frame:true,
        title: 'Simple Form for mouse tests',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',

        items: [
            {
                id: 'textFocus',
                fieldLabel: 'None',
                value: 'blablabla',
                click: function() {
                    alert('Toto');
                }
            },
            {
                id: 'element_1',
                fieldLabel: 'Element 1',
                value: 'Element 1'
            },
            {
                id: 'element_2',
                fieldLabel: 'Element 2',
                value: 'Element 2'
            },
            {
                id: 'element_3',
                fieldLabel: 'Element 3',
                value: 'Element 3'
            },
            {
                id: 'element_4',
                fieldLabel: 'Element 4',
                value: 'Element 4'
            },
            {
                id: 'element_5',
                fieldLabel: 'Element 5',
                value: 'Element 5'
            }
        ]
    });

    mouseTests.render(document.body);

    Ext.get('element_1').on('click', function() {
        Ext.getCmp('element_1').setValue('Element 1 clicked')
    });
    Ext.get('element_2').on('dblclick', function() {
        Ext.getCmp('element_2').setValue('Element 2 double clicked')
    });
    Ext.get('element_3').on('mouseover', function() {
        Ext.getCmp('element_3').setValue('Element 3 mouse over')
    });
    Ext.get('element_4').on('mouseout', function() {
        Ext.getCmp('element_4').setValue('Element 4 mouse out')
    });
    Ext.get('element_5').on('contextmenu', function() {
        Ext.getCmp('element_5').setValue('Element 5 right click')
    });
});