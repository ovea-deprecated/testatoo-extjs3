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

    var states = new Ext.data.SimpleStore({
        fields: ['abbr', 'state', 'nick'],
        data : Ext.data.states
    });

    var form = new Ext.FormPanel({
        labelWidth: 75,
        frame:true,
        title: 'Simple Form',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'combo',

        items: [{
            id: 'dropdown',
            store: states,
            fieldLabel: 'States label',
            editable: true,
            displayField:'state',
            mode: 'local',
            forceSelection: true,
            emptyText:'Select a state...'
        }, {
            id: 'dropdown_disabled',
            store: states,
            fieldLabel: 'States label',
            disabled: true,
            displayField:'state',
            mode: 'local',
            forceSelection: true,
            emptyText:'Select a state...'
        }, {
            id: 'dropdown_hidden',
            store: states,
            fieldLabel: 'States label',
            hidden: true,
            displayField:'state',
            mode: 'local',
            forceSelection: true,
            emptyText:'Select a state...'
        }, {
            id: 'combobox',
            store: states,
            fieldLabel: 'States label',
            maxLength: 20,
            editable: true,
            displayField:'state',
            mode: 'local',
            forceSelection: false,
            emptyText:'Select a state...'
        }, {
            id: 'combobox_disabled',
            store: states,
            fieldLabel: 'States label',
            disabled: true,
            displayField:'state',
            mode: 'local',
            forceSelection: false,
            emptyText:'Select a state...'
        }, {
            id: 'combobox_hidden',
            store: states,
            fieldLabel: 'States label',
            hidden: true,
            displayField:'state',
            mode: 'local',
            forceSelection: false,
            emptyText:'Select a state...'
        }]});

    form.render(document.body);

});
