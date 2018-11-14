//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.uma.jmetal.util.archive.impl;

import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.SolutionListUtils;
import org.uma.jmetal.util.comparator.CrowdingDistanceComparator;
import org.uma.jmetal.util.solutionattribute.DensityEstimator;
import org.uma.jmetal.util.solutionattribute.impl.CrowdingDistance;

import java.util.Comparator;
import java.util.Iterator;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.comparator.EqualSolutionsComparator;
import org.uma.jmetal.util.comparator.SSDComparator;
import org.uma.jmetal.util.solutionattribute.impl.SSD;

/**
 * Created by Antonio J. Nebro on 24/09/14.
 * Modified by Juanjo on 07/04/2015
 */
public class SSDArchive<S extends Solution<?>> extends AbstractBoundedArchive<S> {
  private Comparator<S> crowdingDistanceComparator;
  private DensityEstimator<S> crowdingDistance ;

  public SSDArchive(int maxSize) {
    super(maxSize);
    crowdingDistanceComparator = new SSDComparator<S>() ;
    crowdingDistance = new SSD<S>() ;
  }

  @Override
  public void prune() {
    if (getSolutionList().size() > getMaxSize()) {
      computeDensityEstimator();
      S worst = new SolutionListUtils().findWorstSolution(getSolutionList(), crowdingDistanceComparator) ;
      getSolutionList().remove(worst);
    }
  }

  
  @Override
  public Comparator<S> getComparator() {
    return crowdingDistanceComparator ;
  }
  @Override
  public void computeDensityEstimator() {
    crowdingDistance.computeDensityEstimator(getSolutionList());
  }
}
