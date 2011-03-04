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


    var panel = new Ext.Panel({
        id: 'panelId',
        title: 'PanelTitle',
        width:450,
        defaults:{autoHeight: true}
    });

    var panelDisabled = new Ext.Panel({
        id: 'panel_disabled',
        title: 'PanelTitle',
        disabled: true,
        width:450,
        defaults:{autoHeight: true}
    });

    var panelHidden = new Ext.Panel({
        id: 'panel_hidden',
        title: 'PanelTitle',
        hidden: true,
        width:450,
        defaults:{autoHeight: true}
    });


    new Ext.Button({
        applyTo: 'error',
        id: 'panelError',
        text: 'Button'
    });

    panel.render(document.body);
    panelHidden.render(document.body);
    panelDisabled.render(document.body);

});