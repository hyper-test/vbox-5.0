/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Maxime Dor
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.vbox5_0.setting.snapshot;

import io.kamax.hbox.constant.SnapshotAttribute;
import io.kamax.hbox.exception.ConfigurationException;
import io.kamax.setting._Setting;
import io.kamax.vbox.settings.snapshot.SnapshotMachineIdSetting;
import io.kamax.vbox5_0.setting._SnapshotSettingAction;
import org.virtualbox_5_0.ISnapshot;
import org.virtualbox_5_0.LockType;

public class SnapshotMachineIdSettingAction implements _SnapshotSettingAction {

   @Override
   public LockType getLockType() {
      return LockType.Shared;
   }

   @Override
   public String getSettingName() {
      return SnapshotAttribute.MachineID.getId();
   }

   @Override
   public void set(ISnapshot snap, _Setting setting) {
      throw new ConfigurationException("Read-only setting [" + setting.getName() + "]");
   }

   @Override
   public _Setting get(ISnapshot snap) {
      return new SnapshotMachineIdSetting(snap.getMachine().getId());
   }

}