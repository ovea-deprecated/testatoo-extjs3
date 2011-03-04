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

    new Ext.Panel({width:400, title: 'KeyModifier'}).render(document.body);

    new Ext.Panel({id: '_a', width:100, title: 'a'}).render(document.body);
    new Ext.Panel({id: '_Shift_a', width:100, title: 'Shift+a'}).render(document.body);
    new Ext.Panel({id: '_Ctrl_Shift_a', width:100, title: 'Crtl+Shift+a'}).render(document.body);
});