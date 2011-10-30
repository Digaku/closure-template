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
 * Soy function to short a text.
 * point.
 *
 * @author Robin
 */
@Singleton
class ShortTextFunction implements SoyJsSrcFunction {


  @Inject
  ShortTextFunction() {}


  @Override public String getName() {
    return "ShortText";
  }


  @Override public Set<Integer> getValidArgsSizes() {
    return ImmutableSet.of(2);
  }


  @Override public JsExpr computeForJsSrc(List<JsExpr> args) {

	JsExpr aTxt = args.get(0);
	JsExpr dWidth = args.get(1);
	
	return new JsExpr(
		"soy.$$ShortText(" + aTxt.getText() + "," + dWidth.getText() + ")",
		Integer.MAX_VALUE
	);

  }

}
