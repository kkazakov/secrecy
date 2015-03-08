/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.doplgangr.secrecy.views;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.doplgangr.secrecy.R;

public class FileImportFragment extends VaultsListFragment {
    private ProgressBar addFilepBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_list_vault, container, false);
        addFilepBar = (ProgressBar) view.findViewById(R.id.progressBar);

        ActionBar ab = ((ActionBarActivity) getActivity()).getSupportActionBar();
        if (ab != null)
            ab.setTitle(R.string.Dialog_header__import_files);


        mLinearView = (LinearLayout) view.findViewById(R.id.list);
        mScrollView = (ScrollView) view.findViewById(R.id.scrollView);
        nothing = view.findViewById(R.id.nothing);

        loadVaultList();

        return view;
    }

    @Override
    public void setClickListener(final View mView, final int i) {
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(adapter.getItem(i), mView, i);

                addFilepBar.setVisibility(View.VISIBLE);
            }
        });
    }
}
