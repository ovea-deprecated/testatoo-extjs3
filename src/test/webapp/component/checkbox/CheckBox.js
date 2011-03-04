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

    new Ext.form.FormPanel({
        renderTo:"main",
        title:"Checkbox",
        labelWidth: 110,
        width: 250,
        frame:true,

        items: [{
            items: {
                xtype:'fieldset',
                title: 'Individual Checkboxes',
                autoHeight: true,
                defaultType: 'checkbox',  // each item will be a checkbox
                items: [{
                    id: "dog_id",
                    fieldLabel: 'Favorite Animals',
                    boxLabel: 'Dog',
                    name: 'fav-animal-dog'
                },{
                    id: 'cat_id',
                    checked: true,
                    labelSeparator: '',
                    boxLabel: 'Cat',
                    inputValue: 'Felix the cat'
                },{
                    id: 'monkey_id',
                    labelSeparator: '',
                    boxLabel: 'Monkey',
                    disabled: true
                },{
                    id: 'panda_id',
                    labelSeparator: '',
                    boxLabel: 'Panda',
                    hidden: true
                }
                ]
            }}

        ]}
            );

    new Ext.Button({
        applyTo: 'error',
        id: 'checkboxError',
        text: 'Button'
    });

});
