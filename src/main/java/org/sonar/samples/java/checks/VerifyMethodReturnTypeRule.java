/*
 * SonarQube Java Custom Rules Example
 * Copyright (C) 2016-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.samples.java.checks;

import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.semantic.Type;

import com.google.common.collect.ImmutableList;

@Rule(key = "VerifyMethodReturnType",description="Method shoud not return same as  input parameter type",priority=Priority.MAJOR, tags={"bug"})


public class VerifyMethodReturnTypeRule extends IssuableSubscriptionVisitor{

	@Override
	public List<Kind> nodesToVisit() {
		
		return ImmutableList.of(Tree.Kind.METHOD);
	}

 public void visitNode(Tree tree)
 {
	 MethodTree methodTree = (MethodTree)tree;
 MethodSymbol methodSymbol = methodTree.symbol();
 
 Type returnType = methodSymbol.returnType().type();
 // Check method has only one argument.
// if (methodSymbol.parameterTypes().size() == 1) {
   Type argType = methodSymbol.parameterTypes().get(0);
   // Verify argument type is same as return type.
   System.out.print("returnType.fullyQualifiedName()"+returnType.fullyQualifiedName());
   if (argType.is(returnType.fullyQualifiedName())) {
     // raise an issue on this node of the SyntaxTree
     reportIssue(tree, "Method Return Typs is same as first Parameter");
   }
   
/* if(methodSymbol.parameterTypes().parallelStream().size() >4)
	 reportIssue(methodTree.simpleName(), "Too Many Parameters");
  
 }*/
 	//}
 }
}
