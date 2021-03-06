/**
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import AbstractStatementSourceGenVisitor from './abstract-statement-source-gen-visitor';
import WorkerInvocationStatement from '../../ast/statements/worker-invocation-statement';

/**
 * Worker invocation statement source generation
 */
class WorkerInvocationStatementVisitor extends AbstractStatementSourceGenVisitor {

    /**
     * Can visit check for the worker invocation statement
     * @param {WorkerInvocationStatement} workerInvocationStatement - worker invocation statement ASTNode
     * @return {boolean} true|false - whether the worker invocation can visit or not
     */
    canVisitWorkerInvocationStatement(workerInvocationStatement) {
        return workerInvocationStatement instanceof WorkerInvocationStatement;
    }

    /**
     * Begin visit for the worker invocation statement
     * @param {WorkerInvocationStatement} workerInvocationStatement - worker invocation statement ASTNode
     */
    beginVisitWorkerInvocationStatement(workerInvocationStatement) {
        if (workerInvocationStatement.whiteSpace.useDefault) {
            this.currentPrecedingIndentation = this.getCurrentPrecedingIndentation();
            this.replaceCurrentPrecedingIndentation(this.getIndentation());
        }

        // Calculate the line number
        const lineNumber = this.getTotalNumberOfLinesInSource() + 1;
        workerInvocationStatement.setLineNumber(lineNumber, { doSilently: true });

        const constructedSourceSegment = workerInvocationStatement.getStatementString();
        const numberOfNewLinesAdded = this.getEndLinesInSegment(constructedSourceSegment);
        // Increase the total number of lines
        this.increaseTotalSourceLineCountBy(numberOfNewLinesAdded);

        this.appendSource(constructedSourceSegment);
    }

    /**
     * Begin visit for the worker invocation statement
     * @param {WorkerInvocationStatement} workerInvocationStatement - worker invocation statement ASTNode
     */
    endVisitWorkerInvocationStatement(workerInvocationStatement) {
        const constructedSourceSegment = ';' + workerInvocationStatement.getWSRegion(4)
            + ((workerInvocationStatement.whiteSpace.useDefault) ? this.currentPrecedingIndentation : '');

        // Add the increased number of lines
        const numberOfNewLinesAdded = this.getEndLinesInSegment(constructedSourceSegment);
        this.increaseTotalSourceLineCountBy(numberOfNewLinesAdded);

        this.appendSource(constructedSourceSegment);
        this.getParent().appendSource(this.getGeneratedSource());
    }
}

export default WorkerInvocationStatementVisitor;
