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

    var win = new Ext.Window({
        id: 'myWindow',
        title: 'myWindowTitle',
        layout: 'fit',
        width: 500,
        height: 300,
        closeAction:'hide',
        plain: true,
        items: new Ext.TabPanel({
            autoTabs: true,
            activeTab: 0,
            deferredRender: false,
            border: false
        }),

        buttons: [{
            id: 'button1',
            text: 'Submit',
            disabled: true
        },{
            text: 'Close',
            handler: function() {
                win.hide();
            }
        }]
    });

    var winHidden = new Ext.Window({
        id: 'myWindow_hidden',
        title: 'myWindowTitle',
        layout: 'fit',
        width: 500,
        height: 300,
        closeAction:'hide',
        plain: true
    });

    new Ext.Button({
        id: 'windowError',
        text: 'button',
        applyTo: 'error'
    });

    win.render(document.body);
    winHidden.render(document.body);
    win.show();

});