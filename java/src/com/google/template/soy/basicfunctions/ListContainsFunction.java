/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.template.soy.basicfunctions;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.template.soy.data.SoyData;
import com.google.template.soy.data.restricted.IntegerData;
import com.google.template.soy.javasrc.restricted.JavaCodeUtils;
import com.google.template.soy.javasrc.restricted.JavaExpr;
import com.google.template.soy.javasrc.restricted.SoyJavaSrcFunction;
import com.google.template.soy.jssrc.restricted.JsExpr;
import com.google.template.soy.jssrc.restricted.SoyJsSrcFunction;
import com.google.template.soy.tofu.restricted.SoyTofuFunction;
import static com.google.template.soy.tofu.restricted.SoyTofuFunctionUtils.toSoyData;

import java.util.List;
import java.util.Set;


/**
 * Soy function that check array for contain some item.
 * point.
 *
 * @author Robin
 */
@Singleton
class ListContainsFunction implements SoyJsSrcFunction {


  @Inject
  ListContainsFunction() {}


  @Override public String getName() {
    return "listContains";
  }


  @Override public Set<Integer> getValidArgsSizes() {
    return ImmutableSet.of(2);
  }


  @Override public JsExpr computeForJsSrc(List<JsExpr> args) {

	JsExpr aList = args.get(0);
	JsExpr aKey = args.get(1);
	
    //return new JsExpr("Math.max(" + arg0.getText() + ", " + arg1.getText() + ")", Integer.MAX_VALUE);
	return new JsExpr(aList.getText() + ".indexOf(" + aKey.getText() + ") > -1", Integer.MAX_VALUE);

  }

}
