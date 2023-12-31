/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.permissioncontroller.role.ui.auto;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.android.permissioncontroller.role.ui.RolePreference;
import com.android.permissioncontroller.role.ui.TwoTargetPreference;
import com.android.permissioncontroller.role.ui.UserRestrictionAwarePreferenceMixin;

/**
 * Preference for use in auto lists. Extends {@link TwoTargetPreference} in order to make sure of
 * shared logic between phone and auto settings UI.
 */
public class AutoRolePreference extends Preference implements RolePreference {

    private UserRestrictionAwarePreferenceMixin mUserRestrictionAwarePreferenceMixin =
            new UserRestrictionAwarePreferenceMixin(this);

    public AutoRolePreference(@NonNull Context context,
            @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public AutoRolePreference(@NonNull Context context, @Nullable AttributeSet attrs,
            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AutoRolePreference(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoRolePreference(@NonNull Context context) {
        super(context);
    }

    @Override
    public void setOnSecondTargetClickListener(@Nullable OnSecondTargetClickListener listener) {
    }

    @Override
    public void setUserRestriction(@Nullable String userRestriction) {
        mUserRestrictionAwarePreferenceMixin.setUserRestriction(userRestriction);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        mUserRestrictionAwarePreferenceMixin.onAfterBindViewHolder(holder);
    }

    @Override
    public AutoRolePreference asPreference() {
        return this;
    }
}
